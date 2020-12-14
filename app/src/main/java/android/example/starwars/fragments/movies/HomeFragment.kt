package android.example.starwars.fragments.movies

import android.example.starwars.views.AutoFitGridLayoutManager
import android.example.starwars.adapters.MovieAdapter
import android.example.starwars.databinding.FragmentHomeBinding
import android.example.starwars.repos.RepositoryUtils
import android.example.starwars.utils.Status
import android.example.starwars.viewmodels.movies.HomeViewModel
import android.example.starwars.viewmodels.movies.HomeViewModelFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val factory = HomeViewModelFactory(RepositoryUtils.createMovieRepository(requireContext()))
        val viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = MovieAdapter(MovieAdapter.OnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToMovieItemFragment(it.episodeId)
            findNavController().navigate(directions)
        })

        binding.moviesRecyclerview.adapter = adapter

        val manager = AutoFitGridLayoutManager(this.requireContext(), 600)
        binding.moviesRecyclerview.layoutManager = manager

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
               when(resource.status){
                   Status.SUCCESS -> {
                       binding.progressBarMovies.visibility = View.GONE
                       adapter.submitList(resource.data)
                   }
                   Status.LOADING -> {
                       binding.progressBarMovies.visibility = View.VISIBLE
                   }
                   Status.ERROR -> {
                       binding.progressBarMovies.visibility = View.GONE
                       //TODO Error
                   }
               }
            }
        })

        return binding.root
    }
}