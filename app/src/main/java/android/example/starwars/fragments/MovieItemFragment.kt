package android.example.starwars.fragments

import android.example.starwars.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_movie_item.*

class MovieItemFragment : Fragment(R.layout.fragment_movie_item) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /**  button_character_item.setOnClickListener {
            val action = MovieItemFragmentDirections.actionMovieItemFragmentToCharacterFragment()
            findNavController().navigate(action)
        } */
        button_planet_item.setOnClickListener {
            val action = MovieItemFragmentDirections.actionMovieItemFragmentToPlanetItemFragment()
            findNavController().navigate(action)
        }
        button_starship_item.setOnClickListener {
            val action = MovieItemFragmentDirections.actionMovieItemFragmentToStarshipItemFragment()
            findNavController().navigate(action)
        }
        button_vehicle_item.setOnClickListener {
            val action = MovieItemFragmentDirections.actionMovieItemFragmentToVehicleItemFragment()
            findNavController().navigate(action)
        }
        button_species_item.setOnClickListener {
            val action = MovieItemFragmentDirections.actionMovieItemFragmentToSpeciesItemFragment()
            findNavController().navigate(action)
        }
    }
}