package android.example.starwars.data.local

import android.example.starwars.data.local.dao.MovieDao
import android.example.starwars.properties.MovieFields

class MovieLocalDataSource (private val movieDao: MovieDao) {

    fun getMovies() = movieDao.getAllMovies()

    fun getMovie(id: Int) = movieDao.getMovie(id)

    fun saveMovies(list: List<MovieFields>){
        movieDao.insertAll((list))
    }
}