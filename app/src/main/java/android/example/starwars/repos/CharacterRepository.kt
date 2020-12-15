package android.example.starwars.repos

import android.example.starwars.data.local.CharacterLocalDataSource
import android.example.starwars.data.remote.CharacterRemoteDataSource
import android.example.starwars.utils.performGetOperation

/**
 * Movie repository that contains the remote API Calls and local DAO methods
 */
class CharacterRepository(
    private val characterLocalDataSource: CharacterLocalDataSource,
    private val characterRemoteDataSource: CharacterRemoteDataSource
) {

    fun getCharacter(id: String) = characterLocalDataSource.getCharacter(id)

    fun getAllCharacters() = performGetOperation(
        databaseQuery = {characterLocalDataSource.getCharacters() },
        networkCall = {characterRemoteDataSource.getCharacters()},
        saveCallResult = {characterLocalDataSource.saveCharacters(it.characters) }
    )
}