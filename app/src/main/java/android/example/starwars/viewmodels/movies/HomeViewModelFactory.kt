package android.example.starwars.viewmodels.movies

import android.example.starwars.repos.MovieRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Simple ViewModel factory that provides the [MovieRepository] to the ViewModel.
 */
class HomeViewModelFactory(
    private val repository: MovieRepository
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}