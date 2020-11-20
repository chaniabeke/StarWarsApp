package android.example.starwars.adapters

import android.example.starwars.databinding.RecyclerviewItemCharacterBinding
import android.example.starwars.properties.CharacterFields
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class CharacterAdapter(val onClickListener: OnClickListener) :
    ListAdapter<CharacterFields, CharacterAdapter.CharacterViewHolder>(DiffCallback) {

    /**var characterList = List<CharacterFields>()

    fun setData(getCharactersApiModel: GetCharactersApiModel) {
        characterList = getCharactersApiModel.results
        notifyDataSetChanged()
    }*/


    class CharacterViewHolder(private var binding: RecyclerviewItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterFields: CharacterFields) {
            binding.character = characterFields

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<CharacterFields>() {
        override fun areItemsTheSame(
            oldItem: CharacterFields,
            newItem: CharacterFields
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: CharacterFields,
            newItem: CharacterFields
        ): Boolean {
            return oldItem.name == newItem.name
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
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(character)
        }
    }

        class OnClickListener(val clickListener: (characterFields : CharacterFields) -> Unit) {
            fun onClick(characterFields: CharacterFields) = clickListener(characterFields)
        }
}