package program.java.punch.andr.omdb_client_kotlin.data.database.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.model.Movie

interface FavouriteRepo {
    fun insertFavourite(movie: Movie): Single<Boolean>
    fun getFavourite(): Observable<List<Movie>>
    fun deleteFavourite(movie: Movie): Completable
}