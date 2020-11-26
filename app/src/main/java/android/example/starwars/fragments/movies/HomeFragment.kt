package android.example.starwars.fragments.movies

import android.example.starwars.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_movie_item.setOnClickListener{
            val action = HomeFragmentDirections.actionHomeFragmentToMovieItemFragment()
            findNavController().navigate(action)
        }
    }
}