package ru.mirea.lab6.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_pager_main.*
import kotlinx.android.synthetic.main.fragment_pager_main.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.ui.main.adapters.MainVpAdapter

class MainVpFragment : Fragment() {

    companion object {
        fun newInstance(position: Int) = MainVpFragment().apply { this.position = position }
    }

    private var position: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_pager_main, container, false)
        v.view_pager_main.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val adapter =
            MainVpAdapter(requireContext())
        v.view_pager_main.adapter = adapter
        v.view_pager_main.currentItem = position
        return v
    }

}