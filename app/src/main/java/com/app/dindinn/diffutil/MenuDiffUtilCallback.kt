package com.app.dindinn.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.app.dindinn.entity.Menu

class MenuDiffUtilCallback : DiffUtil.ItemCallback<Menu>() {

    override fun areItemsTheSame(oldItem: Menu, newItem: Menu) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Menu, newItem: Menu) = oldItem.hashCode() == newItem.hashCode()

}