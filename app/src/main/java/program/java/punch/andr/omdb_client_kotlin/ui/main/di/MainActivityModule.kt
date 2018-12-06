package program.java.punch.andr.omdb_client_kotlin.ui.main.di

import dagger.Module
import dagger.Provides
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView

@Module
class MainActivityModule {
    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMvpInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMvpView, MainMvpInteractor>)
            : MainMvpPresenter<MainMvpView, MainMvpInteractor> = mainPresenter

}