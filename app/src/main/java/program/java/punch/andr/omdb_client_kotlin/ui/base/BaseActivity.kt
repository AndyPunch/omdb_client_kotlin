package program.java.punch.andr.omdb_client_kotlin.ui.base

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.GeneralUtils
import program.java.punch.andr.omdb_client_kotlin.utils.NetworkUtils

abstract class BaseActivity : AppCompatActivity(), BaseMvpView, BaseFragment.CallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }


    override fun showErrorDialog(message: String, onDismiss: () -> Unit) {
        GeneralUtils.showErrorDialog(this, message, onDismiss)
    }

    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }


    override fun hideSoftKeyboard(activity: Activity) {
        GeneralUtils.hideSoftKeyboard(activity)
    }

    override fun showSoftKeyboard(activity: Activity) {
        GeneralUtils.showSoftKeyboard(activity)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected abstract fun setUp()

}