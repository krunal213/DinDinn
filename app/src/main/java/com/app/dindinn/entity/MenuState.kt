package com.app.dindinn.entity

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.Uninitialized

data class MenuState(
    val menus : Async<List<Menu>> = Uninitialized
) : MavericksState