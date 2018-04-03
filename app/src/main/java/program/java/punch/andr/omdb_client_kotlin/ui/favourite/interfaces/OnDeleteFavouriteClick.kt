package program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces

import program.java.punch.andr.omdb_client_kotlin.data.model.Movie


interface OnDeleteFavouriteClick {
    fun OnDeleteFavouriteMovieClick(movie: Movie)
}