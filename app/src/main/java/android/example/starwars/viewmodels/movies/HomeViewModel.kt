package android.example.starwars.viewmodels.movies

import android.example.starwars.repos.MovieRepository
import androidx.lifecycle.ViewModel

class HomeViewModel(repository: MovieRepository) : ViewModel() {

    val movies = repository.getAllMovies()
}