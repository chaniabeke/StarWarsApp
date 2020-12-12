package android.example.starwars.data.local

import android.content.Context
import android.example.starwars.properties.MovieFields
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieFields::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

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