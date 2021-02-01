package com.app.dindinn.view.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.app.dindinn.databinding.AdapterMenuBinding
import com.app.dindinn.entity.Menu
import com.app.dindinn.diffutil.MenuDiffUtilCallback
import com.app.dindinn.view.viewholder.MenuViewHolder
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel

class MenuAdapter : ListAdapter<Menu, MenuViewHolder>(
    MenuDiffUtilCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val adapterMenuBinding : AdapterMenuBinding = AdapterMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(adapterMenuBinding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.adapterMenuBinding.menu = getItem(position)

        var shapeAppearanceModel : ShapeAppearanceModel = ShapeAppearanceModel.builder()
            .setAllCorners(CornerFamily.ROUNDED,100f)
            .build()
        var materialShapeDrawable = MaterialShapeDrawable(shapeAppearanceModel)
        materialShapeDrawable.fillColor = ColorStateList.valueOf(Color.BLACK)
        holder.adapterMenuBinding.buttonPrice.background = materialShapeDrawable

    }

}