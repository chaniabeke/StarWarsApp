package android.example.starwars.api

import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonQualifier
import com.squareup.moshi.ToJson

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class WrappedGetCharactersApiModel

class GetCharactersApiModelJsonAdapter {
    @WrappedGetCharactersApiModel
    @FromJson
    fun fromJson(json: GetCharactersApiModel): List<CharacterFields> {
        return json.results
    }

    @ToJson
    fun toJson(@WrappedGetCharactersApiModel value: List<CharacterFields>): GetCharactersApiModel {
        throw UnsupportedOperationException()
    }
}