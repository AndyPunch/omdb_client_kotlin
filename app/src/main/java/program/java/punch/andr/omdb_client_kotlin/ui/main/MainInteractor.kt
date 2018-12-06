package program.java.punch.andr.omdb_client_kotlin.ui.main

import program.java.punch.andr.omdb_client_kotlin.data.network.ApiHelper
import program.java.punch.andr.omdb_client_kotlin.ui.base.BaseInteractor
import program.java.punch.andr.omdb_client_kotlin.ui.main.interfaces.MainMvpInteractor
import javax.inject.Inject


class MainInteractor @Inject internal constructor(val apiHelper: ApiHelper) : BaseInteractor(),
        MainMvpInteractor {


}


