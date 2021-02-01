package com.app.dindinn.repository

import com.app.dindinn.contract.IRepository
import com.app.dindinn.entity.Menu
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

class MenuRepository : IRepository<List<Menu>> {

    override fun get(): Observable<List<Menu>> = Observable.fromCallable<List<Menu>> {
        listOf(
            Menu(
                1,
                "https://b.zmtcdn.com/data/pictures/3/19494063/09d1d351bee7f32b5f90cb563f483ea7_o2_featured_v2.jpg"
            ),
            Menu(
                2,
                "https://b.zmtcdn.com/data/pictures/chains/0/3300300/6e118fe83193856b9ea9e78993344529_o2_featured_v2.jpg"
            ),
            Menu(
                3,
                "https://b.zmtcdn.com/data/pictures/chains/0/18394440/429451b6017ca47881b3b1dbc5dc4d21_o2_featured_v2.jpg"
            ),
            Menu(
                4,
                "https://b.zmtcdn.com/data/pictures/chains/6/3300056/d082ba2f92fb50bdb589e553228454ea_o2_featured_v2.jpg"
            ),
            Menu(
                5,
                "https://b.zmtcdn.com/data/pictures/2/19542532/83abb2309c0d13861817d3d42a9236eb_o2_featured_v2.jpg"
            ),
            Menu(
                6,
                "https://b.zmtcdn.com/data/pictures/chains/2/3300272/67d010c134a54f510e49eab11593c418_o2_featured_v2.jpg"
            )
        )
    }.subscribeOn(Schedulers.io())

}
