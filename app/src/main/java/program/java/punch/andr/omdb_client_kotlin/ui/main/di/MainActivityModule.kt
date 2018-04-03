package program.java.punch.andr.omdb_client_kotlin.ui.main.di

import android.arch.lifecycle.ViewModelProviders
import dagger.Module
import dagger.Provides
import program.java.punch.andr.omdb_client_kotlin.services.RetrofitService
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainActivity
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView
import program.java.punch.andr.omdb_client_kotlin.viewModel.MoviesViewModel
import retrofit2.Retrofit

@Module
class MainActivityModule {
    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMvpInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMvpView, MainMvpInteractor>)
            : MainMvpPresenter<MainMvpView, MainMvpInteractor> = mainPresenter

    @Provides
    internal fun provideApiService(retrofit: Retrofit): RetrofitService {
        return retrofit.create<RetrofitService>(RetrofitService::class.java)
    }

    @Provides
    internal fun provideViewModel(mActivity: MainActivity): MoviesViewModel {
        val model = ViewModelProviders.of(mActivity).get(MoviesViewModel::class.java)
        return model
    }
}