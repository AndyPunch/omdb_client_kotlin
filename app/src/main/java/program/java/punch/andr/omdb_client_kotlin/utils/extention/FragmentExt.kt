package program.java.punch.andr.omdb_client_kotlin.utils.extention


import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}


internal fun FragmentManager.removeFragment(tag: String) {
    this.beginTransaction()
            .disallowAddToBackStack()
            .remove(this.findFragmentByTag(tag)!!)
            .commitNow()
}