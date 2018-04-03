package program.java.punch.andr.omdb_client_kotlin.viewModel

import android.arch.lifecycle.ViewModel
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import java.util.ArrayList


class MoviesViewModel : ViewModel() {
    internal var movieViewModelList: List<Movie> = ArrayList<Movie>()

}