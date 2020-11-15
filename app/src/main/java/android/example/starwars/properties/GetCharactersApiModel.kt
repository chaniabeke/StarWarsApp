package android.example.starwars.properties

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetCharactersApiModel(
    var results: List<CharacterFields>
)