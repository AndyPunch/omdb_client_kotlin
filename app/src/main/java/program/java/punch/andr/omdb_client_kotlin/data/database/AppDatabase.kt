package program.java.punch.andr.omdb_client_kotlin.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import program.java.punch.andr.omdb_client_kotlin.data.database.repository.FavouriteDao
import program.java.punch.andr.omdb_client_kotlin.model.Movie

@Database(entities = [(Movie::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favouriteMovieDao(): FavouriteDao
}
