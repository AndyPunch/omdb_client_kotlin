package program.java.punch.andr.omdb_client_kotlin.ui.main

import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.db.dbHelper.interfaces.DbHelper
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import javax.inject.Inject


class MainInteractor @Inject internal
constructor(private val appDbHelper: DbHelper) : BaseInteractor(appDbHelper = appDbHelper),
        MainMvpInteractor {

    override fun insertFavouriteMovieCall(movie: Movie): Single<Boolean> {
        return appDbHelper.insertFavouriteMovie(movie)
    }
}


