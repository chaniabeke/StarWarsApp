package android.example.starwars.data.local.dao

import android.example.starwars.properties.MovieFields
import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Defines methods for using the [MovieFields] class with Room.
 */
@Dao
interface MovieDao {

    /**
     * Selects and returns all rows in the table.
     */
    @Query("select * from movies order by episodeId")
    fun getAllMovies(): LiveData<List<MovieFields>>

    /**
     * Selects and returns the movie with given Id.
     */
    @Query("select * from movies where episodeId=:id")
    fun getMovie(id : Int) : LiveData<MovieFields>

    /**
     * Insert All Movies in the table.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<MovieFields>)
}