package android.example.starwars.properties

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetCharactersApiModel(
    @Json(name = "results")
    var characters: List<CharacterFields>,
    val next : String?
)