package program.java.punch.andr.omdb_client_kotlin.data.database.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import javax.inject.Inject

class FavouriteRepository @Inject constructor(val favouriteDao: FavouriteDao) : FavouriteRepo {


    override fun insertFavourite(movie: Movie): Single<Boolean> {
        return Single.fromCallable {
            favouriteDao.insertFavouriteMovie(movie)
            true
        }

    }


    override fun deleteFavourite(movie: Movie): Completable {
        return Completable.fromAction { favouriteDao.deleteFavourite(movie) }
    }


    override fun getFavourite(): Observable<List<Movie>> {
        return Observable.fromCallable {
            favouriteDao.getFavourite()
        }
    }


}