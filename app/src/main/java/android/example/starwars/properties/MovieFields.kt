package android.example.starwars.properties

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class MovieFields(
    @Json(name = "characters")
    val characterUrls: List<String>,
    val created: String,
    val director: String,
    val edited: String,
    @Json(name = "episode_id")
    val episodeId: Int,
    @Json(name = "opening_crawl")
    val openingCrawl: String,
    @Json(name = "planets")
    val planetUrls: List<String>,
    val producer: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "species")
    val specieUrls: List<String>,
    @Json(name = "starships")
    val starshipUrls: List<String>,
    val title: String,
    val url: String,
    @Json(name = "vehicles")
    val vehicleUrls: List<String>
) : Parcelable