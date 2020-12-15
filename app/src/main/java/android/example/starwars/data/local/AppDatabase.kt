package android.example.starwars.data.local

import android.content.Context
import android.example.starwars.data.local.dao.CharacterDao
import android.example.starwars.data.local.dao.MovieDao
import android.example.starwars.properties.CharacterFields
import android.example.starwars.properties.MovieFields
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * A database that stores the app's information.
 * And a global method to get access to the database.
 */
@Database(entities = [MovieFields::class, CharacterFields::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun characterDao() : CharacterDao

    companion object{
        @Volatile private var instance : AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase = instance ?: synchronized(this){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, "starWarsDB")
                .fallbackToDestructiveMigration()
                .build()
    }
}