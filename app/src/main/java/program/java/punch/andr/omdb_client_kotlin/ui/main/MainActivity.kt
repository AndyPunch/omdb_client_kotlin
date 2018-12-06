package program.java.punch.andr.omdb_client_kotlin.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_main.*
import program.java.punch.andr.omdb_client_kotlin.R
import program.java.punch.andr.omdb_client_kotlin.archComponents.MoviesViewModel
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseActivity
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.FavouriteFragment
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.MainFragment
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.extention.removeFragment
import program.java.punch.andr.omdb_client_kotlin.utils.extention.replaceFragment
import program.java.punch.andr.omdb_client_kotlin.utils.extention.setupActionBar
import program.java.punch.andr.omdb_client_kotlin.utils.extention.toast
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView, HasSupportFragmentInjector {


    @Inject
    internal lateinit var mPresenter: MainMvpPresenter<MainMvpView, MainMvpInteractor>

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    lateinit var moviesViewModel: MoviesViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        moviesViewModel = ViewModelProviders.of(this).get(MoviesViewModel::class.java)
        mPresenter.onAttach(this)
        setUp()
    }


    override fun setUp() {
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)
        setOnClick()

    }


    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }


    private fun setOnClick() {
        search_button.setOnClickListener {
            if (isNetworkConnected()) {
                hideSoftKeyboard(this)
                val movieTitle = search_edittext.getText().toString().trim { it <= ' ' }
                if (!TextUtils.isEmpty(movieTitle)) {
                    moviesViewModel.movieViewModelList = emptyList()
                    moviesViewModel.isSearchError = false
                    setMovies(movieTitle)
                } else {
                    toast(getString(R.string.title_is_empty))
                }
            } else {
                toast(getString(R.string.network_not_aviable))
            }
        }
    }

    fun setMovies(title: String) {
        replaceFragment(MainFragment.newInstance(title), R.id.container)
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
        supportFragmentManager?.removeFragment(tag = tag)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_favourite, menu)
        val favouriteItem = menu.findItem(R.id.action_favourie)

        favouriteItem.isVisible = moviesViewModel.isSearchVisible
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.action_favourie) {
            hideSoftKeyboard(this)
            replaceFragment(FavouriteFragment.newInstance(), R.id.container, FavouriteFragment.TAG)
            invalidateOptionsMenu()
        } else if (id == android.R.id.home) {
            onBackPressed()
            moviesViewModel.isSearchVisible = true
            invalidateOptionsMenu()
        }

        return super.onOptionsItemSelected(item)
    }

    fun setViewSettings(tag: String) {
        when (tag) {
            MainFragment.TAG -> {
                moviesViewModel.isSearchVisible = true
                setupActionBar(R.id.toolbar) {
                    title = getString(R.string.app_name)
                    setDisplayHomeAsUpEnabled(false)
                    setDisplayShowHomeEnabled(false)

                }

            }

            FavouriteFragment.TAG -> {
                moviesViewModel.isSearchVisible = false
                setupActionBar(R.id.toolbar) {
                    title = getString(R.string.favourite)
                    setDisplayHomeAsUpEnabled(true)
                    setDisplayShowHomeEnabled(true)

                }
            }
        }

        setSearchVisivility()

    }

    private fun setSearchVisivility() {
        if (moviesViewModel.isSearchVisible) {
            search.visibility = View.VISIBLE
        } else {
            search.visibility = View.GONE

        }
    }

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector
}