package android.example.starwars.properties

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "characters")

data class CharacterFields(
    @Json(name = "birth_year")
    val birthYear: String,
    val created: String,
    val edited: String,
    @Json(name = "eye_color")
    val eyeColor: String,
    val gender: String,
    @Json(name = "hair_color")
    val hairColor: String,
    val height: String,
    val mass: String,

    @ColumnInfo(name = "character_name")
    val name: String,

    @Json(name = "skin_color")
    val skinColor : String,

    @PrimaryKey
    val url : String,
)