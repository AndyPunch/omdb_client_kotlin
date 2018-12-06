package program.java.punch.andr.omdb_client_kotlin.archComponents

import android.arch.lifecycle.ViewModel
import program.java.punch.andr.omdb_client_kotlin.model.Movie


class MoviesViewModel : ViewModel() {
    internal var movieViewModelList: List<Movie> = emptyList()
    var isSearchVisible = true
    var isSearchError = false

}