package ru.mirea.lab6.ui.admin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_vp_admin.*
import kotlinx.android.synthetic.main.fragment_vp_admin.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.ItemService
import ru.mirea.lab6.ui.admin.adapters.AdminVpAdapter
import ru.mirea.lab6.util.DataChangedListener

class AdminVpFragment: Fragment() {

    companion object {
        fun newInstance(position: Int) = AdminVpFragment().apply { this.position = position }
    }

    private var position: Int = 0

    private lateinit var listener: DataChangedListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_vp_admin, container, false)
        v.view_pager_admin.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val adminViewPagerAdapter = AdminVpAdapter{ activity?.onBackPressed() }
        listener = object : DataChangedListener { override fun notifyDataChanged() { adminViewPagerAdapter.notifyDataSetChanged() } }
        ItemService.getInstance()?.addDataChangedListener(listener)
        v.view_pager_admin.adapter = adminViewPagerAdapter
        v.view_pager_admin.currentItem = position
        return v
    }

    override fun onDestroy() {
        super.onDestroy()
        ItemService.getInstance()?.removeListener(listener)
    }

}
