package android.example.starwars.viewmodels.characters

import android.example.starwars.repos.CharacterRepository
import android.example.starwars.repos.MovieRepository
import android.example.starwars.viewmodels.movies.HomeViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CharactersViewModelFactory(
private val repository: CharacterRepository
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharactersViewModel::class.java)) {
            return CharactersViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}