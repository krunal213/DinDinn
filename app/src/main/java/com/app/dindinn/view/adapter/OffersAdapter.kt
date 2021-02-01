package com.app.dindinn.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.dindinn.entity.Offer
import androidx.recyclerview.widget.ListAdapter
import com.app.dindinn.databinding.AdapterOffersBinding
import com.app.dindinn.diffutil.OfferDiffUtilCallback
import com.app.dindinn.view.viewholder.OfferViewHolder

class OffersAdapter : ListAdapter<Offer, OfferViewHolder>(OfferDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OfferViewHolder {
        val adapterOffersBinding : AdapterOffersBinding = AdapterOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OfferViewHolder(
            adapterOffersBinding
        )
    }

    override fun onBindViewHolder(holder: OfferViewHolder, position: Int) {
        holder.adapterOffersBinding.offer = getItem(position)
    }

}
