package com.mirea.laba2.ui.info.pager

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mirea.laba2.R
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.databinding.FragmentTechnologyInfoBinding
import com.mirea.laba2.ui.base.fragment.BaseFragment
import dagger.Lazy
import javax.inject.Inject


class TechnologyInfoFragment : BaseFragment(R.layout.fragment_technology_info) {

    companion object {
        private const val ARG_LIST = "ARG_LIST"
        private const val CURRENT_ITEM = "CURRENT_ITEM"
        fun newInstance(data: ArrayList<MainScreenListResponse>,
                        itemIndex: Int) =
            TechnologyInfoFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ARG_LIST, data.toTypedArray())
                    putInt(CURRENT_ITEM, itemIndex)
                }
            }
    }

    @Inject
    lateinit var viewModel: TechnologyInfoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentTechnologyInfoBinding>(view)!!.apply {
            viewmodel = viewModel.apply {
                currentItem.postValue(arguments?.getInt(CURRENT_ITEM))
                adapter.postValue(ViewPagerAdapter(
                    fragmentManager = childFragmentManager,
                    technologies = (arguments?.getParcelableArray(ARG_LIST) as Array<MainScreenListResponse>).toList()
                ))
            }
            lifecycleOwner = this@TechnologyInfoFragment
        }
    }

}