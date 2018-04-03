package program.java.punch.andr.omdb_client_kotlin.ui.main

import io.reactivex.Observer
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.data.model.Movies
import program.java.punch.andr.omdb_client_kotlin.services.RetrofitService
import program.java.punch.andr.omdb_client_kotlin.ui.base.BasePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel
import javax.inject.Inject


class MainPresenter<V : MainMvpView, I : MainMvpInteractor>
@Inject internal constructor(interactor: I) : BasePresenter<V, I>(interactor = interactor),
        MainMvpPresenter<V, I>, Observer<Movies> {

    @Inject
    lateinit var retrofitService: RetrofitService

    @Inject
    lateinit var viewModelMovies: MoviesViewModel

    override fun getMovies(title: String) {
        getView()?.showProgress()
        val moviesObservable = retrofitService.getMovies(title)
        subscribe(moviesObservable, this)

    }

    override fun getViewModel(): MoviesViewModel {
        return viewModelMovies
    }


    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(response: Movies) {
        val moviesList: List<Movie> = response.Search
        getView()?.onMoviesLoaded(moviesList)

    }

    override fun onError(e: Throwable) {
        getView()?.hideProgress()
    }

    override fun onComplete() {
        getView()?.hideProgress()
    }

    override fun insertFavouriteMovie(movie: Movie): Single<Boolean> {
        return interactor!!.insertFavouriteMovieCall(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorReturn({ throwable ->
                    false
                })
    }


}