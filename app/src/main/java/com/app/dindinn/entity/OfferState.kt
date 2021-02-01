package com.app.dindinn.entity

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized

data class OfferState(
    val offers : Async<List<Offer>> = Uninitialized
) : MavericksState