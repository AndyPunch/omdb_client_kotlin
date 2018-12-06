package program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite

import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_favourite.*
import program.java.punch.andr.omdb_client_kotlin.R
import program.java.punch.andr.omdb_client_kotlin.model.Movie
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseFragment
import program.java.punch.andr.omdb_client_kotlin.ui.main.MainActivity
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.adapters.FavouriteAdapter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.fragments.favourite.interfaces.FavouriteFragmentMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.extention.toast
import javax.inject.Inject

class FavouriteFragment : BaseFragment(), FavouriteFragmentMvpView {

    companion object {

        internal val TAG = FavouriteFragment::class.java.simpleName

        fun newInstance(): FavouriteFragment {
            val fragment = FavouriteFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }


    }

    lateinit var adapter: FavouriteAdapter
    lateinit var mActivity: MainActivity

    @Inject
    internal lateinit var presenter: FavouriteFragmentMvpPresenter<FavouriteFragmentMvpView, FavouriteFragmentMvpInteractor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        getExtra()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_favourite, container, false)
        mActivity = activity as MainActivity
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)

    }

    override fun setUp() {
        setAdapter()
        setOnClick()
        mActivity.setViewSettings(TAG)

    }

    private fun setOnClick() {
        adapter.deleteClick.subscribe { it ->
            presenter.deleteFavourite(it)

        }
    }

    private fun setAdapter() {
        adapter = FavouriteAdapter()
        recyclerview_favourite.adapter = adapter
        recyclerview_favourite.layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
        )
        presenter.getFavourite()


    }

    override fun onDestroyView() {
        presenter.onDetach()
        super.onDestroyView()
    }


    override fun onMoviesLoaded(moviesList: List<Movie>) {
        adapter.addMoviesToAdapter(moviesList)
        if (moviesList.isNotEmpty()) {
            list_empty_favourite.text = getString(R.string.empty_str)
        } else {
            list_empty_favourite.text = getString(R.string.empty)
        }


    }

    private fun getExtra() {

    }

    override fun onFavouriteDeleted() {
        getBaseActivity()?.toast(getString(R.string.favourite_deleted))
        presenter.getFavourite()
    }

}
