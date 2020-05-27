package ru.mirea.lab6.ui.admin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_admin_rv.*
import kotlinx.android.synthetic.main.fragment_admin_rv.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.ItemService
import ru.mirea.lab6.ui.admin.adapters.AdminRvAdapter
import ru.mirea.lab6.util.DataChangedListener

class AdminRvFragment : Fragment() {

    companion object {
        fun newInstance(onClick: (Int) -> Unit) = AdminRvFragment().apply { onItemClick = onClick }
    }


    private var onItemClick: (Int) -> Unit = {}

    private lateinit var listener: DataChangedListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment_admin_rv, container, false)
        v.recycler_admin.layoutManager = LinearLayoutManager(context)
        val adminRecyclerAdapter = AdminRvAdapter(onItemClick)
        listener = object : DataChangedListener { override fun notifyDataChanged() { adminRecyclerAdapter.notifyDataSetChanged() } }
        ItemService.getInstance()?.addDataChangedListener(listener)
        v.recycler_admin.adapter = adminRecyclerAdapter
        return v
    }

    override fun onDestroy() {
        super.onDestroy()
        ItemService.getInstance()?.removeListener(listener)
    }
}