package android.example.starwars.viewmodels.characters

import android.app.Application
import android.example.starwars.properties.CharacterFields
import android.example.starwars.repos.CharacterRepository
import android.example.starwars.repos.MovieRepository
import android.example.starwars.viewmodels.movies.MovieItemViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

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