package android.example.starwars.viewmodels.favorite_characters

import android.example.starwars.properties.CharacterFields
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteCharactersViewModel : ViewModel() {
    private val _favoriteCharacters = MutableLiveData<List<CharacterFields>>()
    val favoriteCharacters: LiveData<List<CharacterFields>>
        get() = _favoriteCharacters

    private val _navigateToSelectedFields = MutableLiveData<CharacterFields>()
    val navigateToSelectedFields: LiveData<CharacterFields>
        get() = _navigateToSelectedFields

   /** init{
       // getAllCharacters()
    }*/
}