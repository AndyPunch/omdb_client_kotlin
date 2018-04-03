package program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces

import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView

interface FavouriteMvpView : BaseMvpView {
    fun onMoviesLoaded(moviesList: List<Movie>)
    fun OnFavouriteDeleted()
}