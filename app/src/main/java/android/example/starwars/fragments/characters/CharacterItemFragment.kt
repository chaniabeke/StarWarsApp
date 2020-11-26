package android.example.starwars.fragments.characters

import android.example.starwars.databinding.FragmentCharacterItemBinding
import android.example.starwars.viewmodels.characters.CharacterItemViewModel
import android.example.starwars.viewmodels.characters.CharacterItemViewModelFactory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class CharacterItemFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

       val application = requireNotNull(activity).application

        val binding = FragmentCharacterItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val characterFields = CharacterItemFragmentArgs.fromBundle(requireArguments()).selectedCharacter

       val viewModelFactory = CharacterItemViewModelFactory(characterFields, application)
       binding.viewModel = ViewModelProvider(
           this, viewModelFactory).get(CharacterItemViewModel::class.java)

        return binding.root
    }

}