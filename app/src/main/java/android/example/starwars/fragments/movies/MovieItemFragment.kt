package android.example.starwars.fragments.movies

import android.example.starwars.databinding.FragmentMovieItemBinding
import android.example.starwars.repos.RepositoryUtils
import android.example.starwars.viewmodels.movies.HomeViewModel
import android.example.starwars.viewmodels.movies.HomeViewModelFactory
import android.example.starwars.viewmodels.movies.MovieItemViewModel
import android.example.starwars.viewmodels.movies.MovieItemViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

class MovieItemFragment : Fragment() {

    val arguments : MovieItemFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentMovieItemBinding.inflate(inflater, container, false)
        val factory = MovieItemViewModelFactory(RepositoryUtils.createMovieRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(MovieItemViewModel::class.java)

        binding.lifecycleOwner = this

        viewModel.updateMovie(arguments.movieId)

      viewModel.selectedMovie.observe(viewLifecycleOwner, {
          binding.selectedMovie = it
      })

        return binding.root
    }
}