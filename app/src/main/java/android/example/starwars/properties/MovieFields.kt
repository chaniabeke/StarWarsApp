package android.example.starwars.properties

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "movies")
data class MovieFields(
    val edited: String,
    @Json(name = "episode_id")
    @PrimaryKey
    val episodeId: Int,
    @Json(name = "opening_crawl")
    val openingCrawl: String,
    @Json(name = "release_date")
    val releaseDate: String,
    val title: String,
)
