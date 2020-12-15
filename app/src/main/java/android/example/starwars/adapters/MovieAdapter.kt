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

/**
 * This class implements a [RecyclerView] [ListAdapter] which uses Data Binding to present [List]
 * data, including computing diffs between lists.
 * @param onClick a lambda that takes the [MovieFields]
 */
class MovieAdapter(val onClickListener: OnClickListener) :
    ListAdapter<MovieFields, MovieAdapter.MovieViewHolder>(DiffCallback) {

    /**
     * The [MovieViewHolder] constructor takes the binding variable from the associated
     * GridViewItem, which nicely gives it access to the full [MovieFields] information.
     * It also takes the imageview and give it a fitting image.
     */
    class MovieViewHolder(private var binding: RecyclerviewItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

      val imageView : ImageView
            get() = binding.imageviewMovieposter

        fun bind(movieFields: MovieFields) {
            binding.movie = movieFields
        }
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [MovieFields]
     * has been updated.
     */
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

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            RecyclerviewItemMovieBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(movie)
        }

        // returns the correct image based on the episodeId
        val image : Int = getImage(movie.episodeId)
        //load image movie into imageview
        Glide
           .with(holder.itemView.context)
           .load(image)
           .into(holder.imageView);
    }

    /**
     * Custom listener that handles clicks on [RecyclerView] items.  Passes the [MovieFields]
     * associated with the current item to the [onClick] function.
     * @param clickListener lambda that will be called with the current [MovieFields]
     */
    class OnClickListener(val clickListener: (movieFields: MovieFields) -> Unit) {
        fun onClick(movieFields: MovieFields) = clickListener(movieFields)
    }
}