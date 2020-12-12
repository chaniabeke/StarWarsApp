package android.example.starwars.viewmodels.favorite_characters

import android.example.starwars.properties.CharacterFields
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteCharacterItemViewModel : ViewModel() {
    private val _selectedFavoriteCharacter = MutableLiveData<CharacterFields>()

    val selectedFavoriteCharacter: LiveData<CharacterFields>
        get() = _selectedFavoriteCharacter

  /**  init {
        _selectedFavoriteCharacter.value = characterFields
    }*/
}