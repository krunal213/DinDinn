package com.app.dindinn.viewmodel

import com.airbnb.mvrx.*
import com.app.dindinn.HomeApplication
import com.app.dindinn.contract.IRepository
import com.app.dindinn.entity.Menu
import com.app.dindinn.entity.MenuState
import io.reactivex.schedulers.Schedulers

class MenuViewModel(initialState: MenuState, private val menuRepository: IRepository<List<Menu>>) : MavericksViewModel<MenuState>(initialState) {

    init {
        menuRepository.get()
            .subscribeOn(Schedulers.io())
            .subscribe {
                setState {
                    copy(Success(it))
                }
            }
    }

    companion object : MavericksViewModelFactory<MenuViewModel, MenuState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: MenuState
        ): MenuViewModel? {
            val menuRepository = viewModelContext.app<HomeApplication>().menuRepository
            return MenuViewModel(state, menuRepository)
        }
    }

}