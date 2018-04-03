package program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces

import android.app.Activity

interface BaseMvpView {

    fun showProgress()

    fun hideProgress()

    fun isNetworkConnected(): Boolean

    fun hideSoftKeyboard(activity: Activity)

}
