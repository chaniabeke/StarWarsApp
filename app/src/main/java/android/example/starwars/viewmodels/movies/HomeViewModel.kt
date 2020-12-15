package android.example.starwars.viewmodels.movies

import android.example.starwars.repos.MovieRepository
import androidx.lifecycle.ViewModel

/**
 * The [ViewModel] that is attached to [MoviesFragment].
 * @param repository lambda
 */
class HomeViewModel(repository: MovieRepository) : ViewModel() {
    // sets movies LiveData with return from method
    val movies = repository.getAllMovies()
}