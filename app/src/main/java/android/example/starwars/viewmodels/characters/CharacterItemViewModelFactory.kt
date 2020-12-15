package android.example.starwars.viewmodels.characters

import android.example.starwars.repos.CharacterRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Simple ViewModel factory that provides the [CharacterRepository] to the ViewModel.
 */
class CharacterItemViewModelFactory(
    private val repository: CharacterRepository
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterItemViewModel::class.java)) {
            return CharacterItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}