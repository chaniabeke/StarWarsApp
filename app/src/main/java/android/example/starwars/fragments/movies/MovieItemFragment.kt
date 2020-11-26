package android.example.starwars.fragments.movies

import android.example.starwars.R
import android.example.starwars.databinding.FragmentCharacterItemBinding
import android.example.starwars.databinding.FragmentMovieItemBinding
import android.example.starwars.fragments.characters.CharacterItemFragmentArgs
import android.example.starwars.viewmodels.characters.CharacterItemViewModel
import android.example.starwars.viewmodels.characters.CharacterItemViewModelFactory
import android.example.starwars.viewmodels.movies.MovieItemViewModel
import android.example.starwars.viewmodels.movies.MovieItemViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_movie_item.*

class MovieItemFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val application = requireNotNull(activity).application

        val binding = FragmentMovieItemBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val movieFields = MovieItemFragmentArgs.fromBundle(requireArguments()).selectedMovie

        val viewModelFactory = MovieItemViewModelFactory(movieFields, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(MovieItemViewModel::class.java)

        return binding.root
    }
}