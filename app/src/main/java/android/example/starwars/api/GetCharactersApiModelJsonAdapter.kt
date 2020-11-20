package android.example.starwars.api

import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import com.squareup.moshi.*

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

    val moshi: Moshi = Moshi.Builder().add(GetCharactersApiModelJsonAdapter()).build()
    val adapter: JsonAdapter<GetCharactersApiModel> = moshi.adapter(GetCharactersApiModel::class.java)
    //val movie = adapter.fromJson(MoviesJson))
}