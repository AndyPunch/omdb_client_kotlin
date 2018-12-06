package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BasePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.AppConstants.API_KEY
import program.java.punch.andr.omdb_client_kotlin.utils.AppConstants.TYPE
import javax.inject.Inject

class MainFragmentPresenter<V : MainFragmentMvpView, I : MainFragmentMvpInteractor>
@Inject constructor(interactor: I, disposable: CompositeDisposable) : BasePresenter<V, I>
(interactor = interactor, compositeDisposable = disposable), MainFragmentMvpPresenter<V, I> {

    override fun getMovies(title: String) {
        view?.setProgressVisibility(true)
        compositeDisposable.add(interactor.getMoviesCall(API_KEY, TYPE, title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    view?.setProgressVisibility(false)
                }
                .subscribe(
                        { response ->
                            view?.onMoviesRequested(response.movies)
                        }, {
                })

        )

    }


    override fun insertFavouriteMovie(movie: Movie) {
        compositeDisposable.add(interactor.insertFavouriteMovieCall(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.onMovieInserted(it)
                }, {
                    view?.onMovieInserted(false)
                })

        )
    }

}


