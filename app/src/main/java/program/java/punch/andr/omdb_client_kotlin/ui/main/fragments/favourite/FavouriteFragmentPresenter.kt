package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BasePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpView
import javax.inject.Inject

class FavouriteFragmentPresenter<V : FavouriteFragmentMvpView, I : FavouriteFragmentMvpInteractor>
@Inject constructor(interactor: I, disposable: CompositeDisposable) : BasePresenter<V, I>
(interactor = interactor, compositeDisposable = disposable), FavouriteFragmentMvpPresenter<V, I> {

    override fun deleteFavourite(movie: Movie) {

        compositeDisposable.add(interactor.deleteFavouriteCall(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view?.onFavouriteDeleted()
                }

        )
    }

    override fun getFavourite() {
        compositeDisposable.add(interactor.getFavouriteCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movies ->
                    view?.onMoviesLoaded(movies)
                }, {

                })
        )

    }

}


