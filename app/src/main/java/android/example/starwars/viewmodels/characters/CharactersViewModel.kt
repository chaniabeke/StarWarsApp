package android.example.starwars.viewmodels.characters

import android.example.starwars.data.remote.StarWarsApi
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import android.example.starwars.properties.GetMoviesApiModel
import android.example.starwars.repos.CharacterRepository
import android.example.starwars.repos.MovieRepository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CharactersViewModel(repository: CharacterRepository) : ViewModel() {
        val characters = repository.getAllCharacters()
}