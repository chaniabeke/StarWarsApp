package android.example.starwars.data.local

import android.example.starwars.data.local.dao.CharacterDao
import android.example.starwars.data.local.dao.MovieDao
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.MovieFields

class CharacterLocalDataSource (private val characterDao: CharacterDao) {

    fun getCharacters() = characterDao.getAllCharacters()

    fun getCharacter(id: String) = characterDao.getCharacter(id)

    fun saveCharacters(list: List<CharacterFields>){
        characterDao.insertAll((list))
    }
}