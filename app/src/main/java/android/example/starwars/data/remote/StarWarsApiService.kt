package android.example.starwars.data.remote

import android.example.starwars.properties.GetCharactersApiModel
import android.example.starwars.properties.GetMoviesApiModel
import android.example.starwars.utils.Resource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://swapi.dev/api/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val loggingInterceptor = HttpLoggingInterceptor()
    .setLevel(HttpLoggingInterceptor.Level.BODY)

private val client = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface StarWarsApiService {

    @GET("people/")
    suspend fun getAllCharacters(@Query("page") page : Int): Response<GetCharactersApiModel>

    @GET("films/")
    suspend fun getAllMovies() : Response<GetMoviesApiModel>

}

object StarWarsApi {
    val apiService: StarWarsApiService by lazy { retrofit.create(StarWarsApiService::class.java) }
}