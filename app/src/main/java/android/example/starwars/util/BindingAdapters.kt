package android.example.starwars.util

import android.example.starwars.adapters.CharacterAdapter
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: GetCharactersApiModel) {
    val adapter = recyclerView.adapter as CharacterAdapter
    //adapter.submitList(data)
}