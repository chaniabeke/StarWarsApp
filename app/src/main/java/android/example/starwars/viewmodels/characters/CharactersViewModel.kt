package android.example.starwars.viewmodels.characters

import android.example.starwars.api.StarWarsApi
import android.example.starwars.properties.CharacterFields
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharactersViewModel : ViewModel() {

    private val _characters = MutableLiveData<List<CharacterFields>>()
    val characters: LiveData<List<CharacterFields>>
        get() = _characters

    private val _navigateToSelectedFields = MutableLiveData<CharacterFields>()
    val navigateToSelectedFields: LiveData<CharacterFields>
        get() = _navigateToSelectedFields

    init{
        getAllCharacters()
    }


    private fun getAllCharacters(){
        viewModelScope.launch {
            try {
               val result = StarWarsApi.retrofitService.getAllCharacters(2)
                _characters.value = result.characters
            } catch (e: Exception) {
                Log.e("Failure: ", e.message, e)
            }
        }
    }

    fun displayCharacterFieldsDetails(characterFields: CharacterFields) {
        _navigateToSelectedFields.value = characterFields
    }

    fun displayCharacterFieldsDetailsComplete() {
        _navigateToSelectedFields.value = null
    }
}