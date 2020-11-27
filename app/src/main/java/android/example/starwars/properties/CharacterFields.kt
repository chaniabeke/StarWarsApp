package android.example.starwars.properties

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Entity(tableName = "character_fields_table")
@Parcelize
data class CharacterFields(
    @PrimaryKey(autoGenerate = true)
    var characterId: Long = 0L,

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
) : Parcelable