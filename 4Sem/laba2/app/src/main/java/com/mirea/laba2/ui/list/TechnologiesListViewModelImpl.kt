package com.mirea.laba2.ui.list

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import com.mirea.laba2.R
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.ui.base.viewmodel.BaseViewModelSimple
import com.mirea.laba2.ui.info.pager.TechnologyInfoFragment
import javax.inject.Inject

class TechnologiesListViewModelImpl @Inject constructor(
    lifecycle: Lifecycle,
    private val fragment: TechnologiesListFragment
): BaseViewModelSimple(lifecycle), TechnologiesListViewModel {

    override val items = MutableLiveData<List<MainScreenListResponse>>()

    override fun onItemClick(item: MainScreenListResponse) {
        fragment.fragmentManager?.beginTransaction()?.apply {
            replace(R.id.container, TechnologyInfoFragment.newInstance(
                data = ArrayList(items.value!!.toList()),
                itemIndex = items.value!!.indexOf(item)
            ))
            addToBackStack(null)
            commit()
        }
    }

}