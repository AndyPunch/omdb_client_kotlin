package program.java.punch.andr.omdb_client_kotlin.ui.base

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView

abstract class BasePresenter<V : BaseMvpView, I : BaseMvpInteractor>
internal constructor(protected var interactor: I?) : BaseMvpPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(mvpView: V?) {
        this.view = mvpView
    }

    override fun getView(): V? = view

    override fun onDetach() {
        view = null
        interactor = null
    }

    protected fun <T> subscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }

}

