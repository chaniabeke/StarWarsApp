package android.example.starwars.fragments

import android.example.starwars.databinding.FragmentCharacterItemBinding
import android.example.starwars.viewmodels.CharacterItemViewModel
import android.example.starwars.viewmodels.CharacterItemViewModelFactory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider

class CharacterItemFragment : Fragment() {

   /** private val viewModel: CharacterItemViewModel by lazy {
        ViewModelProvider(this).get(CharacterItemViewModel::class.java)
    }*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

       val application = requireNotNull(activity).application

        val binding = FragmentCharacterItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        //binding.viewModel = viewModel

        val characterfields = CharacterItemFragmentArgs.fromBundle(requireArguments()).selectedCharacter

       val viewModelFactory = CharacterItemViewModelFactory(characterfields, application)
       binding.viewModel = ViewModelProvider(
           this, viewModelFactory).get(CharacterItemViewModel::class.java)

        return binding.root
    }

}