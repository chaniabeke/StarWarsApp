package android.example.starwars.fragments.characters

import android.example.starwars.databinding.FragmentCharacterItemBinding
import android.example.starwars.repos.RepositoryUtils
import android.example.starwars.viewmodels.characters.CharacterItemViewModel
import android.example.starwars.viewmodels.characters.CharacterItemViewModelFactory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

/**
 * This [Fragment] shows the detailed information about a selected item of Star Wars Characters.
 * It sets this information in the [CharacterItemViewModel], which it gets as a ID
 * through Jetpack Navigation's SafeArgs.
 */
class CharacterItemFragment : Fragment() {

    val arguments : CharacterItemFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentCharacterItemBinding.inflate(inflater, container, false)
        val factory = CharacterItemViewModelFactory(RepositoryUtils.createCharacterRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(CharacterItemViewModel::class.java)

        binding.lifecycleOwner = this

        viewModel.updateCharacter(arguments.characterId)

        viewModel.selectedCharacter.observe(viewLifecycleOwner, {
            binding.selectedCharacter = it
        })

        return binding.root
    }
}