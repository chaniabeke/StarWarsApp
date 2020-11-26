package android.example.starwars.viewmodels.characters

import android.app.Application
import android.example.starwars.properties.CharacterFields
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CharacterItemViewModelFactory(
    private val characterFields: CharacterFields,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CharacterItemViewModel::class.java)) {
            return CharacterItemViewModel(characterFields, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}