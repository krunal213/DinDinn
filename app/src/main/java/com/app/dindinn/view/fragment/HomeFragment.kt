package com.app.dindinn.view.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.activityViewModel
import com.airbnb.mvrx.withState
import com.app.dindinn.R
import com.app.dindinn.databinding.FragmentHomeBinding
import com.app.dindinn.view.adapter.SectionsPagerAdapter
import com.app.dindinn.view.adapter.OffersAdapter
import com.app.dindinn.viewmodel.OfferViewModel
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.transition.MaterialSharedAxis

class HomeFragment : Fragment(), MavericksView, AppBarLayout.OnOffsetChangedListener {

    private lateinit var fragmentHomeBinding : FragmentHomeBinding
    private val offerViewModel: OfferViewModel by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        exitTransition = MaterialSharedAxis(MaterialSharedAxis.Y,true).apply {
            duration = 500
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding.recyclerview.adapter =
            OffersAdapter()
        fragmentHomeBinding.recyclerview.layoutManager = LinearLayoutManager(this.requireContext(), LinearLayoutManager.HORIZONTAL,false)
        var pagerSnapHelper = PagerSnapHelper()
        pagerSnapHelper.attachToRecyclerView(fragmentHomeBinding.recyclerview)
        fragmentHomeBinding.indicator.attachToRecyclerView(fragmentHomeBinding.recyclerview)

        fragmentHomeBinding.viewPager.adapter =
            SectionsPagerAdapter(
                requireContext(),
                childFragmentManager
            )

        var shapeAppearanceModel : ShapeAppearanceModel = ShapeAppearanceModel.builder()
            .setTopLeftCorner(CornerFamily.ROUNDED,100f)
            .setTopRightCorner(CornerFamily.ROUNDED,100f)
            .build()
        var materialShapeDrawable = MaterialShapeDrawable(shapeAppearanceModel)
        materialShapeDrawable.fillColor = ColorStateList.valueOf(Color.WHITE)
        fragmentHomeBinding.tabs.background = materialShapeDrawable
        fragmentHomeBinding.tabs.setupWithViewPager(fragmentHomeBinding.viewPager)

        fragmentHomeBinding.appBar.addOnOffsetChangedListener(this)

        fragmentHomeBinding.floatingActionButton.setOnClickListener {
                v: View? ->
            v?.findNavController()?.navigate(R.id.action_homeFragment_to_menuFragment)
        }

        return fragmentHomeBinding.root
    }

    override fun invalidate() = withState(offerViewModel) { state ->
        fragmentHomeBinding.state = state
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        println("VerticalOffset : "+verticalOffset)
        if(verticalOffset<0){
            when(fragmentHomeBinding.floatingActionButton.visibility){
                View.GONE->{
                    fragmentHomeBinding.floatingActionButton.visibility = View.VISIBLE
                }
            }
        }

    }


}