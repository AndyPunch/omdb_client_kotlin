package program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces

import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel


interface FavouriteMvpPresenter<V : FavouriteMvpView, I : FavouriteMvpInteractor> : BaseMvpPresenter<V, I> {
    fun getViewModel(): MoviesViewModel
    fun deleteFavourite(movie: Movie)
    fun getFavourite()

}