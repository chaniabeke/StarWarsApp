package android.example.starwars.properties

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class GetMoviesApiModel(
    @Json(name = "results")
    var movies: List<MovieFields>
)