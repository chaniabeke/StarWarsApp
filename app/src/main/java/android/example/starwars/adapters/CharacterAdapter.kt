package android.example.starwars.adapters

import android.example.starwars.databinding.RecyclerviewItemCharacterBinding
import android.example.starwars.properties.CharacterFields
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 * @param onClick a lambda that takes the [CharacterFields]
 */
class CharacterAdapter(val onClickListener: OnClickListener) :
    ListAdapter<CharacterFields, CharacterAdapter.CharacterViewHolder>(DiffCallback) {

    /**
     * The [CharacterViewHolder] constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [CharacterFields] information.
     */
    class CharacterViewHolder(private var binding: RecyclerviewItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterFields: CharacterFields) {
            binding.character = characterFields
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [CharacterFields]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<CharacterFields>() {
        override fun areItemsTheSame(
            oldItem: CharacterFields,
            newItem: CharacterFields
        ): Boolean {
            return oldItem.url === newItem.url
        }

        override fun areContentsTheSame(
            oldItem: CharacterFields,
            newItem: CharacterFields
        ): Boolean {
            return oldItem == newItem
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            RecyclerviewItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        holder.bind(character)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(character)
        }
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [CharacterFields]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [CharacterFields]
     */
        class OnClickListener(val clickListener: (characterFields : CharacterFields) -> Unit) {
            fun onClick(characterFields: CharacterFields) = clickListener(characterFields)
        }
}