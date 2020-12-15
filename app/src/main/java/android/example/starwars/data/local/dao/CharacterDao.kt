package android.example.starwars.data.local.dao

import android.example.starwars.properties.CharacterFields
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/**
 * Defines methods for using the [CharacterFields] class with Room.
 */
@Dao
interface CharacterDao {

    /**
     * Selects and returns all rows in the table.
     */
    @Query("select * from characters order by character_name")
    fun getAllCharacters(): LiveData<List<CharacterFields>>

    /**
     * Selects and returns the character with given Id.
     */
    @Query("select * from characters where url=:id")
    fun getCharacter(id : String) : LiveData<CharacterFields>

    /**
     * Insert All Characters in the table.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<CharacterFields>)
}