package android.example.starwars.utils

import android.example.starwars.R


fun getImage(episodeId : Int) : Int {
    //TODO default image
    var image : Int = R.drawable.episode_1
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
