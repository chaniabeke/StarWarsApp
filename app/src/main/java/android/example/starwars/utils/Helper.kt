package android.example.starwars.utils

import android.example.starwars.R

/**
 * Returns the fitting image based on episodeId
 * @param episodeId
 */
fun getImage(episodeId : Int) : Int {
    var image : Int = R.drawable.ic_baseline_movie_24
    when (episodeId) {
        1 -> image = R.drawable.episode_1
        2 -> image = R.drawable.episode_2
        3 -> image = R.drawable.episode_3n
        4 -> image = R.drawable.episode_4
        5 -> image = R.drawable.episode_5
        6 -> image = R.drawable.episode_6
    }
    return image
}
