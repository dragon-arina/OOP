package com.mirea.laba2.ui.info.fragment

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mirea.laba2.R
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.databinding.FragmentTechnologyBinding
import com.mirea.laba2.ui.base.fragment.BaseFragment
import dagger.Lazy
import javax.inject.Inject

class TechnologyFragment : BaseFragment(R.layout.fragment_technology) {


    companion object {
        private const val CURRENT_ITEM = "CURRENT_ITEM"
        fun newInstance(data: MainScreenListResponse) =
            TechnologyFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(CURRENT_ITEM, data)
                }
            }
    }

    @Inject
    lateinit var viewModel: TechnologyViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentTechnologyBinding>(view)!!.apply {
            viewmodel = viewModel.apply {
                item.postValue(arguments?.getParcelable(CURRENT_ITEM))
            }
            lifecycleOwner = this@TechnologyFragment
        }
    }

}