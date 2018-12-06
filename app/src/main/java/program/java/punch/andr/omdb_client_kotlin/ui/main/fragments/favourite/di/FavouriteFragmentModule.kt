package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.di

import dagger.Module
import dagger.Provides
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.FavouriteFragmentInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.FavouriteFragmentPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpView


@Module
class FavouriteFragmentModule {

    @Provides
    internal fun provideFavouriteFragmentInteractor(interactor: FavouriteFragmentInteractor):
            FavouriteFragmentMvpInteractor = interactor

    @Provides
    internal fun provideFavouriteFragmentPresenter(presenter: FavouriteFragmentPresenter<FavouriteFragmentMvpView,
            FavouriteFragmentMvpInteractor>)
            : FavouriteFragmentMvpPresenter<FavouriteFragmentMvpView, FavouriteFragmentMvpInteractor> = presenter


}