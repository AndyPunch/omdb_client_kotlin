package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces

import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView


interface FavouriteFragmentMvpView : BaseMvpView {
    fun onMoviesLoaded(moviesList: List<Movie>)
    fun onFavouriteDeleted()

}