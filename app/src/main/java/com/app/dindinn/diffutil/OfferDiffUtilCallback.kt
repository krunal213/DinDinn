package com.app.dindinn.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.app.dindinn.entity.Offer

class OfferDiffUtilCallback : DiffUtil.ItemCallback<Offer>() {

    override fun areItemsTheSame(oldItem: Offer, newItem: Offer) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Offer, newItem: Offer) = oldItem.hashCode() == newItem.hashCode()

}
