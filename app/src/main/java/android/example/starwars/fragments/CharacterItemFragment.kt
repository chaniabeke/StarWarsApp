package android.example.starwars.fragments

import android.example.starwars.R
import android.example.starwars.databinding.FragmentCharacterItemBinding
import android.example.starwars.databinding.FragmentCharactersBinding
import android.example.starwars.viewmodels.CharacterItemViewModel
import android.example.starwars.viewmodels.CharacterViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class CharacterItemFragment : Fragment(R.layout.fragment_character_item) {

    private val viewModel: CharacterItemViewModel by lazy {
        ViewModelProvider(this).get(CharacterItemViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentCharacterItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }

}