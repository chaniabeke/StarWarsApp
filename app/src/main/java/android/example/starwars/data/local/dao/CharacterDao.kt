package android.example.starwars.data.local.dao

import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.MovieFields
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Query("select * from characters")
    fun getAllCharacters(): LiveData<List<CharacterFields>>

    @Query("select * from characters where characterId=:id")
    fun getCharacter(id : Int) : LiveData<CharacterFields>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<CharacterFields>)
}