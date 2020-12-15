package android.example.starwars.fragments.characters

import android.example.starwars.adapters.CharacterAdapter
import android.example.starwars.databinding.FragmentCharactersBinding
import android.example.starwars.repos.RepositoryUtils
import android.example.starwars.utils.Status
import android.example.starwars.viewmodels.characters.CharactersViewModel
import android.example.starwars.viewmodels.characters.CharactersViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

/**
 * This fragment shows the characters of the star wars API.
 */
class CharactersFragment : Fragment() {

    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the [CharactersFragment]
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     * It also observes the characters Resource List in the viewmodel
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentCharactersBinding.inflate(inflater, container, false)

        val factory = CharactersViewModelFactory(RepositoryUtils.createCharacterRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(CharactersViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = CharacterAdapter(CharacterAdapter.OnClickListener {
            val directions = CharactersFragmentDirections.actionCharactersFragmentToCharacterItemFragment(it.url)
            findNavController().navigate(directions)
        })

        binding.charactersRecyclerview.adapter = adapter

        viewModel.characters.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when(resource.status){
                    Status.SUCCESS -> {
                        binding.progressBarCharacters.visibility = View.GONE
                        adapter.submitList(resource.data)
                    }
                    Status.LOADING -> {
                        binding.progressBarCharacters.visibility = View.VISIBLE
                    }
                    Status.ERROR -> {
                        binding.progressBarCharacters.visibility = View.GONE
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        return binding.root
    }
}