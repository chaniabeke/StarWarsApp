package android.example.starwars.viewmodels.characters

import android.app.Application
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.MovieFields
import android.example.starwars.repos.CharacterRepository
import android.example.starwars.repos.MovieRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel


class CharacterItemViewModel(private  val repository: CharacterRepository) : ViewModel(){

    private lateinit var _selectedCharacter : LiveData<CharacterFields>

    val selectedCharacter: LiveData<CharacterFields>
        get() = _selectedCharacter

    fun updateCharacter(id: String){
        _selectedCharacter = repository.getCharacter(id)
    }


}