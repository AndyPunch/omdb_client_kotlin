package program.java.punch.andr.omdb_client_kotlin.db.dbHelper

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.db.AppDatabase
import program.java.punch.andr.omdb_client_kotlin.db.dbHelper.interfaces.DbHelper
import javax.inject.Inject


class AppDbHelper @Inject constructor(private val mAppDatabase: AppDatabase) : DbHelper {
    override fun insertFavouriteMovie(movie: Movie): Single<Boolean> {
        return Single.fromCallable {
            mAppDatabase
                    .favouriteMovieDao().insertFavouriteMovie(movie)

            true
        }
    }

    override fun deleteFavourite(movie: Movie): Completable {
        return Completable.fromAction { mAppDatabase.favouriteMovieDao().deleteFavourite(movie) }
    }


    override fun getFavourite(): Flowable<List<Movie>> {
        return Flowable.fromCallable { mAppDatabase.favouriteMovieDao().getFavouriteMovies() }
    }


}