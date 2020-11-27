package android.example.starwars.fragments.characters

import android.example.starwars.adapters.CharacterAdapter
import android.example.starwars.databinding.FragmentCharactersBinding
import android.example.starwars.viewmodels.characters.CharactersViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class CharactersFragment : Fragment() {

    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(this).get(CharactersViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentCharactersBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = CharacterAdapter(CharacterAdapter.OnClickListener {
            viewModel.displayCharacterFieldsDetails(it)
        })
        binding.charactersRecyclerview.adapter = adapter

        viewModel.characters.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.navigateToSelectedFields.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    CharactersFragmentDirections.actionCharactersFragmentToCharacterItemFragment(it)
                )
                viewModel.displayCharacterFieldsDetailsComplete()
            }
        })

        return binding.root
    }
}