package program.java.punch.andr.omdb_client_kotlin.ui.base

import android.app.Activity
import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView
import program.java.punch.andr.omdb_client_kotlin.utils.GeneralUtils
import program.java.punch.andr.omdb_client_kotlin.utils.NetworkUtils

abstract class BaseActivity : AppCompatActivity(), BaseMvpView {
    private var mProgressDialog: ProgressDialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDI()
        baseSetUp()

    }


    private fun performDI() = AndroidInjection.inject(this)

    private fun baseSetUp() {

    }


    override fun showProgress() {
        hideProgress()
        mProgressDialog = GeneralUtils.showLoadingDialog(this)
    }

    override fun hideProgress() {
        mProgressDialog?.let {
            if (it.isShowing) it.cancel()
        }

    }


    override fun isNetworkConnected(): Boolean {
        return NetworkUtils.isNetworkConnected(applicationContext)
    }


    override fun hideSoftKeyboard(activity: Activity) {
        GeneralUtils.hideSoftKeyboard(activity)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected abstract fun setUp()

}