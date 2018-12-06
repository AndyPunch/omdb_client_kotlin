package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces

import io.reactivex.Observable
import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.model.Movies
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor


interface MainFragmentMvpInteractor : BaseMvpInteractor {
    fun getMoviesCall(apikey: String, type: String, title: String): Observable<Movies>
    fun insertFavouriteMovieCall(movie: Movie): Single<Boolean>

}