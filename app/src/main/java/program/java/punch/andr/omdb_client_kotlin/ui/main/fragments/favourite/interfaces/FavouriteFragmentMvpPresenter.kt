package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces

import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpPresenter

interface FavouriteFragmentMvpPresenter<V : FavouriteFragmentMvpView, I : FavouriteFragmentMvpInteractor> : BaseMvpPresenter<V, I> {
    fun deleteFavourite(movie: Movie)
    fun getFavourite()

}
