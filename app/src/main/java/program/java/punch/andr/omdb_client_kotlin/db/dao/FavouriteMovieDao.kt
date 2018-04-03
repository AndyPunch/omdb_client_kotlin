package program.java.punch.andr.omdb_client_kotlin.db.dao

import android.arch.persistence.room.*
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie


@Dao
interface FavouriteMovieDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertFavouriteMovie(movie: Movie)

    @Query("SELECT * FROM favourite_movies")
    fun getFavouriteMovies(): List<Movie>

    @Delete
    fun deleteFavourite(movie: Movie)

}