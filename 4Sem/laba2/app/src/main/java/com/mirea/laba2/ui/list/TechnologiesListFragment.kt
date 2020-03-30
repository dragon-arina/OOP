package com.mirea.laba2.ui.list

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.mirea.laba2.R
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.databinding.FragmentTechnologiesListBinding
import com.mirea.laba2.ui.base.fragment.BaseFragment
import javax.inject.Inject

class TechnologiesListFragment : BaseFragment(R.layout.fragment_technologies_list) {

    companion object {
        private const val ARG_LIST = "ARG_LIST"
        fun newInstance(data: ArrayList<MainScreenListResponse>) =
            TechnologiesListFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(ARG_LIST, data.toTypedArray())
                }
            }
    }

    @Inject
    lateinit var viewModel: TechnologiesListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataBindingUtil.bind<FragmentTechnologiesListBinding>(view)!!.apply {
            viewmodel = viewModel.apply {
                items.postValue((arguments?.getParcelableArray(ARG_LIST) as Array<MainScreenListResponse>).toList())
            }
            lifecycleOwner = this@TechnologiesListFragment
        }
    }

}