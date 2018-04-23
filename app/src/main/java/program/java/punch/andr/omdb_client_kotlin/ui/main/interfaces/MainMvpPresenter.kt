package program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces

import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel

interface MainMvpPresenter<V : MainMvpView, I : MainMvpInteractor> : BaseMvpPresenter<V, I> {
    fun getMovies(title: String)

    fun getViewModel(): MoviesViewModel

    fun insertFavouriteMovie(movie: Movie)

}