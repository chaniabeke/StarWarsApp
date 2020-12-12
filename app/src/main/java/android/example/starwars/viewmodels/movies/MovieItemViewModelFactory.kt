package android.example.starwars.viewmodels.movies

import android.app.Application
import android.example.starwars.properties.MovieFields
import android.example.starwars.repos.MovieRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MovieItemViewModelFactory(
    private val repository: MovieRepository
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieItemViewModel::class.java)) {
            return MovieItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}