package com.app.dindinn

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.app.dindinn.contract.IRepository
import com.app.dindinn.repository.MenuRepository
import com.app.dindinn.repository.OfferRepository

class HomeApplication : Application() {

    val offerRepository = OfferRepository()
    val menuRepository = MenuRepository()

    override fun onCreate() {
        super.onCreate()
        Mavericks.initialize(this)
    }

}