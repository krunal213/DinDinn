package com.app.dindinn.bindingAdapters

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.Async
import com.bumptech.glide.Glide
import com.hrskrs.instadotlib.InstaDotView
import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator

@BindingAdapter("asyncList")
fun <T> setListAdapterData(recyclerView: RecyclerView, data : Async<List<T>>?) {
    @Suppress("UNCHECKED_CAST")
    (recyclerView.adapter as ListAdapter<Any, *>).submitList(data?.invoke() ?: emptyList())
}

@BindingAdapter("imageUrl")
fun loadImage(view: AppCompatImageView, imageUrl : String?) {
    try {
        Glide.with(view.context)
            .load(imageUrl)
            .into(view)
    }catch (ex : Exception){
        ex.printStackTrace()
    }
}

@BindingAdapter("noOfPages")
fun <T> noOfPages(view : ScrollingPagerIndicator, data : Async<List<T>>?){
    var size = data?.invoke()?.size
    if (size != null) {
        view.visibleDotCount = 3
    }
}