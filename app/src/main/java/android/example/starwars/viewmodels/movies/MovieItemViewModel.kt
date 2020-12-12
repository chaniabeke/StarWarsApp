package android.example.starwars.viewmodels.movies

import android.app.Application
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.MovieFields
import android.example.starwars.repos.MovieRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MovieItemViewModel(private  val repository: MovieRepository) : ViewModel(){

    private lateinit var _selectedMovie : LiveData<MovieFields>

    val selectedMovie: LiveData<MovieFields>
        get() = _selectedMovie

    fun updateMovie(id: Int){
        _selectedMovie = repository.getMovie(id)
    }
}