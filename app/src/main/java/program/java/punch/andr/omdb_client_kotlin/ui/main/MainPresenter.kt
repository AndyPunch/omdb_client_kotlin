package program.java.punch.andr.omdb_client_kotlin.ui.main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.services.RetrofitService
import program.java.punch.andr.omdb_client_kotlin.ui.base.BasePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel
import javax.inject.Inject


class MainPresenter<V : MainMvpView, I : MainMvpInteractor>
@Inject internal constructor(interactor: I, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, compositeDisposable = disposable),
        MainMvpPresenter<V, I> {

    @Inject
    lateinit var retrofitService: RetrofitService

    @Inject
    lateinit var viewModelMovies: MoviesViewModel


    override fun getMovies(title: String) {
        getView()?.showProgress()
        compositeDisposable.add(retrofitService.getMovies(title)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response ->
                            val moviesList: List<Movie>
                            moviesList = response.Search
                            getView()?.onMoviesLoaded(moviesList)
                            getView()?.hideProgress()
                        }) { throwable -> getView()?.hideProgress() })
    }

    override fun getViewModel(): MoviesViewModel {
        return viewModelMovies
    }


    override fun insertFavouriteMovie(movie: Movie) {
        interactor?.let {
            compositeDisposable.add(it.insertFavouriteMovieCall(movie)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .onErrorReturn({ throwable -> false })
                    .subscribe({ aBoolean -> getView()?.onMovieInserted(aBoolean) }))

        }
    }

}