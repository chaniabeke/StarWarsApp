package android.example.starwars.adapters

import android.example.starwars.databinding.RecyclerviewItemCharacterBinding
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class CharacterAdapter(val onClickListener: OnClickListener) :
    ListAdapter<GetCharactersApiModel, CharacterAdapter.CharacterViewHolder>(DiffCallback) {

    /**var characterList = List<CharacterFields>()

    fun setData(getCharactersApiModel: GetCharactersApiModel) {
        characterList = getCharactersApiModel.results
        notifyDataSetChanged()
    }*/


    class CharacterViewHolder(private var binding: RecyclerviewItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterFields: CharacterFields) {
            binding.character = characterFields
            binding.executePendingBindings()

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GetCharactersApiModel>() {
        override fun areItemsTheSame(
            oldItem: GetCharactersApiModel,
            newItem: GetCharactersApiModel
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: GetCharactersApiModel,
            newItem: GetCharactersApiModel
        ): Boolean {
            return oldItem.results == newItem.results
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            RecyclerviewItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val getCharactersApiModel = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(getCharactersApiModel.results[position])
            holder.bind(getCharactersApiModel.results[position])
        }
    }

        class OnClickListener(val clickListener: (characterFields : CharacterFields) -> Unit) {
            fun onClick(characterFields: CharacterFields) = clickListener(characterFields)
        }
}