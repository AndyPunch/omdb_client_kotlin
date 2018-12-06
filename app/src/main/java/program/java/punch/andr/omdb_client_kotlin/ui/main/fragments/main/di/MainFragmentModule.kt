package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.di

import dagger.Module
import dagger.Provides
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.MainFragmentInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.MainFragmentPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpView


@Module
class MainFragmentModule {

    @Provides
    internal fun provideMainFragmentInteractor(interactor: MainFragmentInteractor):
            MainFragmentMvpInteractor = interactor

    @Provides
    internal fun provideMainFragmentPresenter(presenter: MainFragmentPresenter<MainFragmentMvpView,
            MainFragmentMvpInteractor>)
            : MainFragmentMvpPresenter<MainFragmentMvpView, MainFragmentMvpInteractor> = presenter


}