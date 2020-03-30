package com.mirea.laba2.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import com.mirea.laba2.R
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.databinding.ActivityMainBinding
import com.mirea.laba2.ui.base.activity.BaseActivity
import com.mirea.laba2.ui.list.TechnologiesListFragment
import dagger.Lazy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    companion object {
        const val ARG_LIST = "LIST"
    }

    @Inject
    override
    lateinit var binding: Lazy<ActivityMainBinding>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.getParcelableArrayListExtra<MainScreenListResponse>(ARG_LIST)?.let { data ->
            supportFragmentManager.beginTransaction()
                .apply {
                    replace(R.id.container, TechnologiesListFragment.newInstance(data))
                    commit()
                }
        }
    }

}
