package program.java.punch.andr.omdb_client_kotlin.ui.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import dagger.android.support.AndroidSupportInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.GeneralUtils
import program.java.punch.andr.omdb_client_kotlin.utils.NetworkUtils


abstract class BaseFragment : Fragment(), BaseMvpView {

    private var parentActivity: BaseActivity? = null

    private var viewAwareDisposables: CompositeDisposable? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.parentActivity = activity
            activity?.onFragmentAttached()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    protected fun addViewDisposable(disposable: Disposable) = viewAwareDisposables?.add(disposable)

    override fun onDestroyView() {
        viewAwareDisposables?.dispose()
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewAwareDisposables = CompositeDisposable()
        setUp()
    }

    override fun showErrorDialog(message: String, onDismiss: () -> Unit) {
        activity?.let {
            GeneralUtils.showErrorDialog(it, message, onDismiss)
        }
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(this.context!!)
    }

    override fun hideSoftKeyboard(activity: Activity) {
        GeneralUtils.hideSoftKeyboard(activity)
    }

    override fun showSoftKeyboard(activity: Activity) {
        GeneralUtils.showSoftKeyboard(activity)
    }

    fun getBaseActivity() = parentActivity

    interface CallBack {
        fun onFragmentAttached()
        fun onFragmentDetached(tag: String)
    }

    abstract fun setUp()
}