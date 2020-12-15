package android.example.starwars.viewmodels.characters

import android.example.starwars.repos.CharacterRepository
import androidx.lifecycle.ViewModel

/**
 * The [ViewModel] that is attached to [CharactersFragment].
 * @param repository lambda
 */
class CharactersViewModel(repository: CharacterRepository) : ViewModel() {
        // sets characters LiveData with return from method
        val characters = repository.getAllCharacters()
}