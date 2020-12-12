package android.example.starwars.repos

import android.example.starwars.data.local.CharacterLocalDataSource
import android.example.starwars.data.local.MovieLocalDataSource
import android.example.starwars.data.remote.CharacterRemoteDataSource
import android.example.starwars.data.remote.MovieRemoteDataSource
import android.example.starwars.utils.performGetOperation

class CharacterRepository(
    private val characterLocalDataSource: CharacterLocalDataSource,
    private val characterRemoteDataSource: CharacterRemoteDataSource
) {

    fun getCharacter(id: Int) = characterLocalDataSource.getCharacter(id)

    fun getAllCharacters() = performGetOperation(
        databaseQuery = {characterLocalDataSource.getCharacters() },
        networkCall = {characterRemoteDataSource.getCharacters()},
        saveCallResult = {characterLocalDataSource.saveCharacters(it.characters) }
    )
}