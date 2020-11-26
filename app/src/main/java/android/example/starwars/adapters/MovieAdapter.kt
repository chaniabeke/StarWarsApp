package android.example.starwars.adapters

import android.example.starwars.databinding.RecyclerviewItemMovieBinding
import android.example.starwars.properties.MovieFields
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(val onClickListener: OnClickListener) :
    ListAdapter<MovieFields, MovieAdapter.MovieViewHolder>(DiffCallback) {

    class MovieViewHolder(private var binding: RecyclerviewItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieFields: MovieFields) {
            binding.movie = movieFields
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieFields>() {
        override fun areItemsTheSame(
            oldItem: MovieFields,
            newItem: MovieFields
        ): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: MovieFields,
            newItem: MovieFields
        ): Boolean {
            return oldItem.episodeId == newItem.episodeId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            RecyclerviewItemMovieBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movie)
        }
    }

    class OnClickListener(val clickListener: (movieFields: MovieFields) -> Unit) {
        fun onClick(movieFields: MovieFields) = clickListener(movieFields)
    }
}