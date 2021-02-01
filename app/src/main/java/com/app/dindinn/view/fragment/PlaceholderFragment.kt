package com.app.dindinn.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.app.dindinn.databinding.FragmentMainBinding
import com.app.dindinn.view.adapter.MenuAdapter
import com.app.dindinn.view.decoration.MenuItemDecoration
import com.app.dindinn.viewmodel.MenuViewModel
class PlaceholderFragment : Fragment(), MavericksView {

    private lateinit var fragmentMainBinding : FragmentMainBinding
    private val offerViewModel: MenuViewModel by activityViewModel()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false)
        fragmentMainBinding.recyclerviewItems.adapter = MenuAdapter()
        fragmentMainBinding.recyclerviewItems.layoutManager = LinearLayoutManager(this.requireActivity(),LinearLayoutManager.VERTICAL,false)
        fragmentMainBinding.recyclerviewItems.addItemDecoration(MenuItemDecoration())
        return fragmentMainBinding.root
    }

    override fun invalidate() = withState(offerViewModel) { state ->
        fragmentMainBinding.state = state
    }

}