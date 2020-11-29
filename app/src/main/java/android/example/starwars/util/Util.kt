package android.example.starwars.util

import android.example.starwars.R
import android.widget.ImageView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule


fun getImage(episodeId : Int) : Int {
    var image : Int = R.drawable.img_movie_1
    when (episodeId) {
        1 -> image = R.drawable.img_movie_1
        2 -> image = R.drawable.img_movie_2
        3 -> image = R.drawable.img_movie_3
        4 -> image = R.drawable.img_movie_4
        5 -> image = R.drawable.img_movie_5
        6 -> image = R.drawable.img_movie_6
    }
    return image
}
