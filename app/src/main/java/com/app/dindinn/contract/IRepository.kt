package com.app.dindinn.contract

import com.app.dindinn.entity.Menu
import io.reactivex.Observable

interface IRepository<T> {
    fun get(): Observable<T>
}