package program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces

import io.reactivex.Completable
import io.reactivex.Flowable
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor


interface FavouriteMvpInteractor : BaseMvpInteractor {
    fun deleteFavouriteCall(movie: Movie): Completable
    fun getFavouriteCall(): Flowable<List<Movie>>
}