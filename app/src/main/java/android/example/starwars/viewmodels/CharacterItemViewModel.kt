package android.example.starwars.viewmodels

import android.app.Application
import android.example.starwars.properties.CharacterFields
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class CharacterItemViewModel(characterFields: CharacterFields, app: Application) : ViewModel(){

    private val _selectedCharacter = MutableLiveData<CharacterFields>()

    val selectedCharacter: LiveData<CharacterFields>
        get() = _selectedCharacter

    init {
        _selectedCharacter.value = characterFields
    }
}