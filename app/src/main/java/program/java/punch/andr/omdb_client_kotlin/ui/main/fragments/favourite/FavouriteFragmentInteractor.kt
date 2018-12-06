package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite


import io.reactivex.Completable
import io.reactivex.Observable
import program.java.punch.andr.omdb_client_kotlin.data.database.repository.FavouriteRepo
import program.java.punch.andr.omdb_client_kotlin.data.network.ApiHelper
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpInteractor
import javax.inject.Inject

class FavouriteFragmentInteractor @Inject internal constructor(val apiHelper: ApiHelper, val favouriteRepo: FavouriteRepo) :
        BaseInteractor(), FavouriteFragmentMvpInteractor {

    override fun deleteFavouriteCall(movie: Movie): Completable {
        return favouriteRepo.deleteFavourite(movie)
    }


    override fun getFavouriteCall(): Observable<List<Movie>> {
        return favouriteRepo.getFavourite()
    }


}