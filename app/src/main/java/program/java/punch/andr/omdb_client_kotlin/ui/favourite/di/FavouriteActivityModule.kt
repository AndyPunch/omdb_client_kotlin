package program.java.punch.andr.omdb_client_kotlin.ui.favourite.di

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.FavouriteActivity
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.FavouriteInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.FavouritePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpView
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel

@Module
class FavouriteActivityModule {
    @Provides
    internal fun provideFavouriteInteractor(favouriteInteractor: FavouriteInteractor):
            FavouriteMvpInteractor = favouriteInteractor

    @Provides
    internal fun provideFavouritePresenter(favouritePresenter: FavouritePresenter<FavouriteMvpView, FavouriteMvpInteractor>)
            : FavouriteMvpPresenter<FavouriteMvpView, FavouriteMvpInteractor> = favouritePresenter


    @Provides
    internal fun provideViewModel(mActivity: FavouriteActivity): MoviesViewModel {
        val model = ViewModelProviders.of(mActivity).get(MoviesViewModel::class.java)
        return model
    }
}