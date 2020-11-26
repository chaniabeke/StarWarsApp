package android.example.starwars.fragments.favorite_characters

import android.example.starwars.R
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_favorite_characters.*

class FavoriteCharactersFragment : Fragment(R.layout.fragment_favorite_characters) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        button_character_item.setOnClickListener {
            val action =
                FavoriteCharactersFragmentDirections.actionFavoriteCharactersFragmentToFavoriteCharactersItemFragment()
            findNavController().navigate(action)
        }
    }
}