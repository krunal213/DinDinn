package com.app.dindinn.repository

import com.app.dindinn.contract.IRepository
import com.app.dindinn.entity.Offer
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class OfferRepository : IRepository<List<Offer>> {

    override fun get(): Observable<List<Offer>> = Observable.fromCallable<List<Offer>> {
       listOf(
            Offer(
                1,
                "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEAFLAT-5-CASHBPAYT4D535087D/0x1920/70/3.jpg"
            ),
            Offer(
                2,
                "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEAFLAT-5-CASHBPAYT4D535087D/0x1920/70/3.jpg"
            ),
            Offer(
                3,
                "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEAFLAT-5-CASHBPAYT4D535087D/0x1920/70/3.jpg"
            ),
            Offer(
                4,
                "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEAFLAT-5-CASHBPAYT4D535087D/0x1920/70/3.jpg"
            ),
            Offer(
                5,
                "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEAFLAT-5-CASHBPAYT4D535087D/0x1920/70/3.jpg"
            ),
            Offer(
                6,
                "https://assetscdn1.paytm.com/images/catalog/product/D/DE/DEAFLAT-5-CASHBPAYT4D535087D/0x1920/70/3.jpg"
            )
        )
    }.subscribeOn(Schedulers.io())

}