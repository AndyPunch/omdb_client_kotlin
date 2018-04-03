package program.java.punch.andr.omdb_client_kotlin.ui.base

import program.java.punch.andr.omdb_client_kotlin.db.dbHelper.interfaces.DbHelper
import program.java.punch.andr.omdb_client_kotlin.ui.base.interfaces.BaseMvpInteractor

open class BaseInteractor() : BaseMvpInteractor {

    protected lateinit var mAppDbHelper: DbHelper


    constructor (appDbHelper: DbHelper) : this() {
        this.mAppDbHelper = appDbHelper

    }


}
