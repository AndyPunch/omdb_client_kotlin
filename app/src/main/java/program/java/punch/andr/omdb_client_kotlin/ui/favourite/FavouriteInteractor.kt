package program.java.punch.andr.omdb_client_kotlin.ui.favourite

import io.reactivex.Completable
import io.reactivex.Flowable
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.db.dbHelper.interfaces.DbHelper
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpInteractor
import javax.inject.Inject


class FavouriteInteractor @Inject internal
constructor(private val appDbHelper: DbHelper) : BaseInteractor(appDbHelper = appDbHelper),
        FavouriteMvpInteractor {

    override fun deleteFavouriteCall(movie: Movie): Completable {
        return appDbHelper.deleteFavourite(movie)
    }


    override fun getFavouriteCall(): Flowable<List<Movie>> {
        return appDbHelper.getFavourite()
    }

}


