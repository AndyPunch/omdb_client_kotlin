package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces

import io.reactivex.Completable
import io.reactivex.Observable
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor


interface FavouriteFragmentMvpInteractor : BaseMvpInteractor {
    fun deleteFavouriteCall(movie: Movie): Completable
    fun getFavouriteCall(): Observable<List<Movie>>

}