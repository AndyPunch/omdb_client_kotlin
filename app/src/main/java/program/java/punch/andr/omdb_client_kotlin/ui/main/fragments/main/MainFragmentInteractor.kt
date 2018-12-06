package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main


import io.reactivex.Observable
import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.data.database.repository.FavouriteRepo
import program.java.punch.andr.omdb_client_kotlin.data.network.ApiHelper
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.model.Movies
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpInteractor
import javax.inject.Inject

class MainFragmentInteractor @Inject internal constructor(val apiHelper: ApiHelper, val favouriteRepo: FavouriteRepo) :
        BaseInteractor(), MainFragmentMvpInteractor {


    override fun getMoviesCall(apikey: String, type: String, title: String): Observable<Movies> {
        return apiHelper.getMovies(apikey, type, title)
    }

    override fun insertFavouriteMovieCall(movie: Movie): Single<Boolean> {
        return favouriteRepo.insertFavourite(movie)
    }


}