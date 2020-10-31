package android.example.starwars.fragments

import android.example.starwars.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_planets.*

class PlanetsFragment : Fragment(R.layout.fragment_planets) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_planet_item.setOnClickListener {
            val action = PlanetsFragmentDirections.actionPlanetsFragmentToPlanetItemFragment()
            findNavController().navigate(action)
        }
    }
}