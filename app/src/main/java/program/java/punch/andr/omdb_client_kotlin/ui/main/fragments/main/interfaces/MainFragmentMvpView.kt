package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces

import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView


interface MainFragmentMvpView : BaseMvpView {
    fun onMoviesRequested(moviesList: List<Movie>?)
    fun setProgressVisibility(isVisible: Boolean)
    fun onMovieInserted(aBoolean: Boolean)

}