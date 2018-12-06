package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*
import program.java.punch.andr.omdb_client_kotlin.R
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseFragment
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainActivity
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.adapters.MoviesAdapter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.main.interfaces.MainFragmentMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.AppConstants.MOVIE_TITLE
import program.java.punch.andr.omdb_client_kotlin.utils.extention.toast
import javax.inject.Inject

class MainFragment : BaseFragment(), MainFragmentMvpView {

    companion object {

        internal val TAG = MainFragment::class.java.simpleName

        fun newInstance(title: String): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putString(MOVIE_TITLE, title)
            fragment.arguments = args
            return fragment
        }

    }

    var movieTitle: String? = null

    lateinit var adapter: MoviesAdapter
    lateinit var mActivity: MainActivity

    @Inject
    internal lateinit var presenter: MainFragmentMvpPresenter<MainFragmentMvpView, MainFragmentMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        getExtra()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        mActivity = activity as MainActivity
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)

    }


    override fun setUp() {
        setAdapter()
        if (mActivity.moviesViewModel.movieViewModelList.isNotEmpty()) {
            adapter.addMoviesToAdapter(mActivity.moviesViewModel.movieViewModelList)
        } else {
            if (!mActivity.moviesViewModel.isSearchError) {
                presenter.getMovies(movieTitle!!)
            }


        }


        setOnClick()
        mActivity.setViewSettings(TAG)

    }

    private fun setOnClick() {
        adapter.favouriteClick.subscribe { it ->
            presenter.insertFavouriteMovie(it)

        }
    }

    private fun setAdapter() {
        adapter = MoviesAdapter()
        recyclerview.adapter = adapter
        recyclerview.layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
        )


    }

    override fun onMoviesRequested(moviesList: List<Movie>?) {
        if (moviesList != null && moviesList.isNotEmpty()) {
            mActivity.moviesViewModel.isSearchError = false
            mActivity.moviesViewModel.movieViewModelList = moviesList
            adapter.addMoviesToAdapter(moviesList)

        } else {
            mActivity.moviesViewModel.isSearchError = true
            adapter.clearMovies()
            list_empty.setText(R.string.no_results)
        }
    }

    private fun getExtra() {
        movieTitle = arguments!!.getString(MOVIE_TITLE)
    }

    override fun setProgressVisibility(isVisible: Boolean) {
        if (isVisible) {
            pb_main.visibility = View.VISIBLE
        } else {
            pb_main.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }


    override fun onMovieInserted(aBoolean: Boolean) {
        if (aBoolean) {
            getBaseActivity()?.toast(getString(R.string.movie_is_added))

        } else {
            getBaseActivity()?.toast(getString(R.string.already_added))
        }
    }


}
