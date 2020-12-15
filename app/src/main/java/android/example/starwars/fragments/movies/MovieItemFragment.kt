package android.example.starwars.fragments.movies

import android.example.starwars.databinding.FragmentMovieItemBinding
import android.example.starwars.repos.RepositoryUtils
import android.example.starwars.viewmodels.movies.MovieItemViewModel
import android.example.starwars.viewmodels.movies.MovieItemViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs

/**
 * This [Fragment] shows the detailed information about a selected item of Star Wars Movies.
 * It sets this information in the [MovieItemViewModel], which it gets as a ID
 * through Jetpack Navigation's SafeArgs.
 */
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