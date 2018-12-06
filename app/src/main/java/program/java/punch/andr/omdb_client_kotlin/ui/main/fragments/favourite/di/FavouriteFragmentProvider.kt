package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.FavouriteFragment


@Module
internal abstract class FavouriteFragmentProvider {

    @ContributesAndroidInjector(modules = [FavouriteFragmentModule::class])
    internal abstract fun provideFavouriteFragmentFactory(): FavouriteFragment
}