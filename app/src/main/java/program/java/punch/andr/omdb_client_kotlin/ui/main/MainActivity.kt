package program.java.punch.andr.omdb_client_kotlin.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_main.*
import program.java.punch.andr.omdb_client_kotlin.R
import program.java.punch.andr.omdb_client_kotlin.adapters.MoviesAdapter
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseActivity
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.FavouriteActivity
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.OnAddFavouriteClick
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMvpView, OnAddFavouriteClick {


    private var layoutManager: RecyclerView.LayoutManager? = null

    private var moviesAdapter: MoviesAdapter? = null

    @Inject
    internal lateinit var mPresenter: MainMvpPresenter<MainMvpView, MainMvpInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter.onAttach(this)
        setUp()
    }


    override fun setUp() {
        setSupportActionBar(toolbar)
        title = getString(R.string.app_name)
        setAdapter()
        setOnClickListeners()

    }

    fun setAdapter() {
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        moviesAdapter = MoviesAdapter(this, this)
        recyclerview.layoutManager = layoutManager
        recyclerview.adapter = moviesAdapter
        list_empty.let { recyclerview.setEmptyView(it) }
        if (mPresenter.getViewModel().movieViewModelList.size > 0) {
            moviesAdapter?.addMoviesToAdapter(mPresenter.getViewModel().movieViewModelList)
        }
    }


    override fun onMoviesLoaded(moviesList: List<Movie>?) {
        if (moviesList != null) {
            mPresenter.getViewModel().movieViewModelList = moviesList
            moviesAdapter?.addMoviesToAdapter(moviesList)
        } else {
            moviesAdapter?.clearMovies()
            list_empty.setText(R.string.no_results)
        }
    }


    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }


    private fun setOnClickListeners() {
        search_button.setOnClickListener {
            if (isNetworkConnected()) {
                hideSoftKeyboard(this)
                val movieTitle = search_edittext.getText().toString().trim { it <= ' ' }
                if (!TextUtils.isEmpty(movieTitle)) {
                    mPresenter.getMovies(movieTitle)
                } else {
                    Toast.makeText(this, R.string.title_is_empty, Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, R.string.network_not_aviable, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun OnAddFavouriteMovieClick(movie: Movie) {
        val isFavouriteMovieAdded = mPresenter.insertFavouriteMovie(movie)
        isFavouriteMovieAdded.subscribe({ aBoolean ->
            if (aBoolean!!) {
                Toast.makeText(application, R.string.movie_is_added, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(application, R.string.already_added, Toast.LENGTH_LONG).show()
            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_favourite, menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        if (id == R.id.action_favourie) {

            val favouriteIntent = Intent(this, FavouriteActivity::class.java)
            startActivity(favouriteIntent)

        }

        return super.onOptionsItemSelected(item)
    }


}