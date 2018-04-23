package program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces

import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView


interface MainMvpView : BaseMvpView {
    fun onMoviesLoaded(moviesList: List<Movie>?)
    fun onMovieInserted(aBoolean: Boolean)
}