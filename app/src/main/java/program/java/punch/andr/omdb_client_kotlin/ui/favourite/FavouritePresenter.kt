package program.java.punch.andr.omdb_client_kotlin.ui.favourite

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BasePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpView
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel
import javax.inject.Inject


class FavouritePresenter<V : FavouriteMvpView, I : FavouriteMvpInteractor>
@Inject internal constructor(interactor: I) : BasePresenter<V, I>(interactor = interactor),
        FavouriteMvpPresenter<V, I> {


    @Inject
    lateinit var viewModelMovies: MoviesViewModel


    override fun getViewModel(): MoviesViewModel {
        return viewModelMovies
    }

    override fun deleteFavourite(movie: Movie) {
        interactor!!.deleteFavouriteCall(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ getView()?.OnFavouriteDeleted() })
    }

    override fun getFavourite() {
        getView()?.showProgress()
        interactor!!.getFavouriteCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError({ throwable -> getView()?.hideProgress() })
                .doOnComplete({ getView()?.hideProgress() })
                .subscribe({ movies -> this@FavouritePresenter.getView()?.onMoviesLoaded(movies) })
    }


}