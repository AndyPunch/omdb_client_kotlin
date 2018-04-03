package program.java.punch.andr.omdb_client_kotlin.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.FavouriteActivity
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.di.FavouriteActivityModule
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainActivity
import program.java.punch.andr.omdb_client_kotlin.ui.main.di.MainActivityModule

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(FavouriteActivityModule::class)])
    abstract fun bindFavouriteActivity(): FavouriteActivity


}
