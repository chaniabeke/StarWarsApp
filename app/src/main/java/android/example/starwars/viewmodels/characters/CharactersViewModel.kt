package android.example.starwars.viewmodels.characters

import android.example.starwars.data.remote.StarWarsApi
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import android.example.starwars.properties.GetMoviesApiModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharactersViewModel() : ViewModel() {

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

                var charactersList = listOf<CharacterFields>()
                var getCharactersApiModel : GetCharactersApiModel
                var index : Int = 1

                do{
                    getCharactersApiModel  = StarWarsApi.apiService.getAllCharacters(index)
                    charactersList += getCharactersApiModel.characters
                    index ++
                }while (getCharactersApiModel.next != null)

                _characters.value = charactersList

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