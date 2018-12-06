package program.java.punch.andr.omdb_client_kotlin.data.database.repository

import android.arch.persistence.room.*
import program.java.punch.andr.omdb_client_kotlin.model.Movie


@Dao
interface FavouriteDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertFavouriteMovie(movie: Movie)

    @Query("SELECT * FROM favourite_movies")
    fun getFavourite(): List<Movie>

    @Delete
    fun deleteFavourite(movie: Movie)

}