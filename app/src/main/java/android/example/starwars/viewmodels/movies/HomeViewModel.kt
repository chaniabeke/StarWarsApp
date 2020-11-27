package android.example.starwars.viewmodels.movies

import android.example.starwars.api.StarWarsApi
import android.example.starwars.properties.MovieFields
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _movies = MutableLiveData<List<MovieFields>>()
    val movies: LiveData<List<MovieFields>>
        get() = _movies

    private val _navigateToSelectedFields = MutableLiveData<MovieFields>()
    val navigateToSelectedFields: LiveData<MovieFields>
        get() = _navigateToSelectedFields

    init{
        getAllMovies()
    }


    private fun getAllMovies(){
        viewModelScope.launch {
            try {
                val result = StarWarsApi.retrofitService.getAllMovies()
                _movies.value = result.movies
            } catch (e: Exception) {
                Log.e("Failure: ", e.message, e)
            }
        }
    }

    fun displayMovieFieldsDetails(movieFields: MovieFields) {
        _navigateToSelectedFields.value = movieFields
    }

    fun displayMovieFieldsDetailsComplete() {
        _navigateToSelectedFields.value = null
    }
}