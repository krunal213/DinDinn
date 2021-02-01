package com.app.dindinn.viewmodel

import com.airbnb.mvrx.*
import com.app.dindinn.HomeApplication
import com.app.dindinn.contract.IRepository
import com.app.dindinn.entity.Offer
import com.app.dindinn.entity.OfferState
import io.reactivex.schedulers.Schedulers

class OfferViewModel(initialState: OfferState, private val offerRepository: IRepository<List<Offer>>) : MavericksViewModel<OfferState>(initialState) {

    init {
        offerRepository.get()
            .subscribeOn(Schedulers.io())
            .subscribe {
                setState {
                    copy(Success(it))
                }
            }
    }

    companion object : MavericksViewModelFactory<OfferViewModel, OfferState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: OfferState
        ): OfferViewModel? {
            val offerRepository = viewModelContext.app<HomeApplication>().offerRepository
            return OfferViewModel(state, offerRepository)
        }
    }

}