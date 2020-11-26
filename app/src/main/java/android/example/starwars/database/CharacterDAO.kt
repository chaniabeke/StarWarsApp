package android.example.starwars.database

import android.example.starwars.properties.CharacterFields
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query

interface CharacterDAO {

    @Insert
    suspend fun insert(characterFields: CharacterFields)

    @Query("SELECT * from character_fields_table WHERE characterId = :key")
    suspend fun get(key: Long): CharacterFields?

    @Query("SELECT * FROM character_fields_table ORDER BY character_name")
    fun getAllCharacters(): LiveData<List<CharacterFields>>

}