package android.example.starwars.database

import android.content.Context
import android.example.starwars.properties.CharacterFields
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CharacterFields::class], version = 1, exportSchema = false)
abstract class CharacterDatabase : RoomDatabase() {

    abstract val characterDAO: CharacterDAO

    companion object {

        @Volatile
        private var INSTANCE: CharacterDatabase? = null

        fun getInstance(context: Context): CharacterDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CharacterDatabase::class.java,
                        "favorite_characters_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}