package program.java.punch.andr.omdb_client_kotlin.ui.base

import io.reactivex.disposables.CompositeDisposable
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpView

abstract class BasePresenter<V : BaseMvpView, I : BaseMvpInteractor>
internal constructor(protected var interactor: I?,
                     protected val compositeDisposable: CompositeDisposable) : BaseMvpPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(mvpView: V?) {
        this.view = mvpView
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}

