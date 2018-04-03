package program.java.punch.andr.omdb_client_kotlin.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.db.dao.FavouriteMovieDao

@Database(entities = [(Movie::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favouriteMovieDao(): FavouriteMovieDao
}
