package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces

import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpPresenter

interface MainFragmentMvpPresenter<V : MainFragmentMvpView, I : MainFragmentMvpInteractor> : BaseMvpPresenter<V, I> {
    fun getMovies(title: String)
    fun insertFavouriteMovie(movie: Movie)

}
