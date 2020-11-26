package android.example.starwars.fragments.movies

import android.example.starwars.adapters.MovieAdapter
import android.example.starwars.databinding.FragmentHomeBinding
import android.example.starwars.viewmodels.movies.HomeViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = FragmentHomeBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val adapter = MovieAdapter(MovieAdapter.OnClickListener {
            viewModel.displayMovieFieldsDetails(it)
        })
        binding.moviesRecyclerview.adapter = adapter

        viewModel.movies.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.navigateToSelectedFields.observe(viewLifecycleOwner, Observer {
            if ( null != it ) {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToMovieItemFragment(it)
                )
                viewModel.displayMovieFieldsDetailsComplete()
            }
        })

        return binding.root
    }
}