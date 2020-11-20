package android.example.starwars.api

import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.GetCharactersApiModel
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://swapi.dev/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StarWarsApiService {
    @GET("people/")
    /**@WrappedGetCharactersApiModel*/
    suspend fun getAllCharacters() : GetCharactersApiModel
}

object StarWarsApi {
    val retrofitService : StarWarsApiService by lazy { retrofit.create(StarWarsApiService::class.java) }
}