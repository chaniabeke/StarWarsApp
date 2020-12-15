package android.example.starwars.viewmodels.movies

import android.example.starwars.properties.MovieFields
import android.example.starwars.repos.MovieRepository
import androidx.lifecycle.*

/**
 * The [ViewModel] that is attached to [MoviesFragment].
 * @param repository
 */
class MovieItemViewModel(private  val repository: MovieRepository) : ViewModel(){

    private lateinit var _selectedMovie : LiveData<MovieFields>

    val selectedMovie: LiveData<MovieFields>
        get() = _selectedMovie

    /**
     * update [_selectedMovie] with the returned [MovieFields] from method
     * @param Int
     */
    fun updateMovie(id: Int){
        _selectedMovie = repository.getMovie(id)
    }
}