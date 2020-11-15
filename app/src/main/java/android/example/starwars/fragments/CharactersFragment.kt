package android.example.starwars.fragments

import android.example.starwars.R
import android.example.starwars.adapters.CharacterAdapter
import android.example.starwars.databinding.FragmentCharactersBinding
import android.example.starwars.viewmodels.CharacterViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private val viewModel: CharacterViewModel by lazy {
        ViewModelProvider(this).get(CharacterViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentCharactersBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.characterRecyclerview.adapter = CharacterAdapter(CharacterAdapter.OnClickListener {
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedFields.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(CharactersFragmentDirections.actionCharactersFragmentToCharacterItemFragment(it))
                viewModel.displayPropertyDetailsComplete()
            }
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /**button_character_item.setOnClickListener {
            val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterItemFragment()
            findNavController().navigate(action)
        }*/
    }
}