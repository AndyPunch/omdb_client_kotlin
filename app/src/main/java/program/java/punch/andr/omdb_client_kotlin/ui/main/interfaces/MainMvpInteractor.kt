package program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces

import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor


interface MainMvpInteractor : BaseMvpInteractor {
    fun insertFavouriteMovieCall(movie: Movie): Single<Boolean>
}