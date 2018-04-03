package program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces

interface BaseMvpPresenter<V : BaseMvpView, I : BaseMvpInteractor> {

    fun getView(): V?

    fun onAttach(mvpView: V?)

    fun onDetach()



}