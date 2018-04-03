package program.java.punch.andr.omdb_client_kotlin.ui.favourite


import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.content_favourite.*
import program.java.punch.andr.omdb_client_kotlin.R
import program.java.punch.andr.omdb_client_kotlin.adapters.FavouriteAdapter
import program.java.punch.andr.omdb_client_kotlin.data.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseActivity
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.FavouriteMvpView
import program.java.punch.andr.omdb_client_kotlin.ui.favourite.interfaces.OnDeleteFavouriteClick
import javax.inject.Inject


class FavouriteActivity : BaseActivity(), FavouriteMvpView, OnDeleteFavouriteClick {

    private var layoutManager: RecyclerView.LayoutManager? = null

    private var favouriteAdapter: FavouriteAdapter? = null

    @Inject
    internal lateinit var mPresenter: FavouriteMvpPresenter<FavouriteMvpView, FavouriteMvpInteractor>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favourite)
        mPresenter.onAttach(this)
        setUp()
    }


    override fun setUp() {
        setSupportActionBar(toolbar)
        title = getString(R.string.favourite_movies)
        setAdapter()
        getFavourite()
    }

    private fun setAdapter() {
        layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        favouriteAdapter = FavouriteAdapter(this, this)
        recyclerview_favourite.layoutManager = layoutManager
        recyclerview_favourite.adapter = favouriteAdapter
        list_empty_favourite.let { recyclerview_favourite.setEmptyView(it) }
        if (mPresenter.getViewModel().movieViewModelList.size > 0) {
            favouriteAdapter?.addMoviesToAdapter(mPresenter.getViewModel().movieViewModelList)
        }
    }


    fun getFavourite() {
        mPresenter.getFavourite()
    }

    override fun onMoviesLoaded(moviesList: List<Movie>) {
        mPresenter.getViewModel().movieViewModelList = moviesList
        favouriteAdapter?.addMoviesToAdapter(moviesList)

    }


    override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }


    override fun OnDeleteFavouriteMovieClick(movie: Movie) {
        mPresenter.deleteFavourite(movie)
    }

    override fun OnFavouriteDeleted() {
        Toast.makeText(this, R.string.favourite_deleted, Toast.LENGTH_LONG).show()
        getFavourite()
    }

}