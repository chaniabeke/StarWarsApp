package android.example.starwars.adapters

import android.example.starwars.databinding.RecyclerviewItemMovieBinding
import android.example.starwars.properties.MovieFields
import android.example.starwars.utils.getImage
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(val onClickListener: OnClickListener) :
    ListAdapter<MovieFields, MovieAdapter.MovieViewHolder>(DiffCallback) {

    class MovieViewHolder(private var binding: RecyclerviewItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

      val imageView : ImageView
            get() = binding.imageviewMovieposter

        fun bind(movieFields: MovieFields) {
            binding.movie = movieFields
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MovieFields>() {
        override fun areItemsTheSame(
            oldItem: MovieFields,
            newItem: MovieFields
        ): Boolean {
            return oldItem.episodeId === newItem.episodeId
        }

        override fun areContentsTheSame(
            oldItem: MovieFields,
            newItem: MovieFields
        ): Boolean {
            return oldItem.edited == newItem.edited
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

  val image : Int = getImage(movie.episodeId)
       Glide
           .with(holder.itemView.context)
           .load(image)
           .centerCrop()
           .into(holder.imageView);
    }

    class OnClickListener(val clickListener: (movieFields: MovieFields) -> Unit) {
        fun onClick(movieFields: MovieFields) = clickListener(movieFields)
    }
}