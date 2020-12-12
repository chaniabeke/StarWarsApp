package android.example.starwars.data.local

import android.example.starwars.properties.GetMoviesApiModel
import android.example.starwars.properties.MovieFields
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Query("select * from movies")
    fun getAllMovies(): LiveData<List<MovieFields>>

    @Query("select * from movies where episodeId=:id")
    fun getMovie(id : Int) : LiveData<MovieFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<MovieFields>)
}