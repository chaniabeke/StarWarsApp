package android.example.starwars.fragments

import android.example.starwars.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment : Fragment(R.layout.fragment_characters) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_character_item.setOnClickListener {
            val action = CharactersFragmentDirections.actionCharactersFragmentToCharacterItemFragment()
            findNavController().navigate(action)
        }
    }
}