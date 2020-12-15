package android.example.starwars.viewmodels.characters

import android.example.starwars.properties.CharacterFields
import android.example.starwars.repos.CharacterRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

/**
 * The [ViewModel] that is attached to [CharactersFragment].
 * @param repository
 */
class CharacterItemViewModel(private  val repository: CharacterRepository) : ViewModel(){

    private lateinit var _selectedCharacter : LiveData<CharacterFields>

    val selectedCharacter: LiveData<CharacterFields>
        get() = _selectedCharacter

    /**
     * update [_selectedCharacter] with the returned [CharacterFields] from method
     * @param String
     */
    fun updateCharacter(id: String){
        _selectedCharacter = repository.getCharacter(id)
    }


}