package android.example.starwars.viewmodels

import android.example.starwars.api.StarWarsApi
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.ArrayList

class CharacterViewModel : ViewModel() {

    private val _getCharactersApiModel = MutableLiveData<GetCharactersApiModel>()

    val getCharactersApiModel: LiveData<GetCharactersApiModel>?
        get() = _getCharactersApiModel

    private val _navigateToSelectedProperty = MutableLiveData<CharacterFields>()

    val navigateToSelectedFields: LiveData<CharacterFields>
        get() = _navigateToSelectedProperty

    init{
        getAllCharacters()
    }


    private fun getAllCharacters(){
        viewModelScope.launch {
            try {
               val result = StarWarsApi.retrofitService.getAllCharacters()
                _getCharactersApiModel.value = result
            } catch (e: Exception) {
                Log.e("Failure: ", e.message, e)
               // _characters.value = ArrayList()
            }
        }
    }

    fun displayPropertyDetails(characterFields: CharacterFields) {
        _navigateToSelectedProperty.value = characterFields
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}