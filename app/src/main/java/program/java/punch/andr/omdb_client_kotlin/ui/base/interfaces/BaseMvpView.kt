package program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces

import android.app.Activity

interface BaseMvpView {

    fun isNetworkConnected(): Boolean
    fun hideSoftKeyboard(activity: Activity)
    fun showSoftKeyboard(activity: Activity)
    fun showErrorDialog(message: String, onDismiss: () -> Unit = {})

}
