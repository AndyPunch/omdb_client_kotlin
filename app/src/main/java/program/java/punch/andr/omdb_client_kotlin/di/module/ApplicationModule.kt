package program.java.punch.andr.omdb_client_kotlin.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import program.java.punch.andr.omdb_client_kotlin.db.AppDatabase
import program.java.punch.andr.omdb_client_kotlin.db.dbHelper.AppDbHelper
import program.java.punch.andr.omdb_client_kotlin.db.dbHelper.interfaces.DbHelper
import program.java.punch.andr.omdb_client_kotlin.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(context,
            AppDatabase::class.java, AppConstants.DB_NAME).build()

    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }


    @Provides
    @Singleton
    internal fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()


    @Singleton
    @Provides
    internal fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory =
            RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    internal fun provideRetrofit(gsonConverterFactory: GsonConverterFactory,
                                 rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .build()
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

}