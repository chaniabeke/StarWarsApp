package android.example.starwars.viewmodels.movies

import android.app.Application
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.MovieFields
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieItemViewModel(movieFields: MovieFields, app: Application) : ViewModel(){

    private val _selectedMovie = MutableLiveData<MovieFields>()

    val selectedMovie: LiveData<MovieFields>
        get() = _selectedMovie

    init {
        _selectedMovie.value = movieFields
    }
}