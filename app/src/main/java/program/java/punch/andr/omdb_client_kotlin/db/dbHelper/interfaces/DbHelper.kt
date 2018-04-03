package program.java.punch.andr.omdb_client_kotlin.db.dbHelper.interfaces

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie


interface DbHelper {
    fun insertFavouriteMovie(movie: Movie): Single<Boolean>
    fun deleteFavourite(movie: Movie): Completable
    fun getFavourite(): Flowable<List<Movie>>
}