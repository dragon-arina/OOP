package com.mirea.laba2.ui.info.pager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.ui.info.fragment.TechnologyFragment


class ViewPagerAdapter(
    private val technologies: List<MainScreenListResponse>,
    fragmentManager: FragmentManager
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(i: Int): Fragment = TechnologyFragment.newInstance(technologies[i])

    override fun getCount(): Int = technologies.size
}