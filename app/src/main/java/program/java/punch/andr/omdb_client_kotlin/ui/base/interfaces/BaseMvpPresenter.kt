package program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces

interface BaseMvpPresenter<V : BaseMvpView, I : BaseMvpInteractor> {

    fun onAttach(mvpView: V?)

    fun onDetach()


}