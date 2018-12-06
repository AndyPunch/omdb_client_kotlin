package program.java.punch.andr.omdb_client_kotlin.ui.main

import io.reactivex.disposables.CompositeDisposable
import program.java.punch.andr.omdb_client_kotlin.ui.base.BasePresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpPresenter
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpView
import javax.inject.Inject


class MainPresenter<V : MainMvpView, I : MainMvpInteractor>
@Inject internal constructor(interactor: I, disposable: CompositeDisposable)
    : BasePresenter<V, I>(interactor = interactor, compositeDisposable = disposable),
        MainMvpPresenter<V, I> {


}