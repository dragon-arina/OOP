package ru.mirea.lab6.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_rv_main.*
import kotlinx.android.synthetic.main.fragment_rv_main.view.*
import ru.mirea.lab6.R
import ru.mirea.lab6.item.ItemService
import ru.mirea.lab6.ui.main.adapters.MainRvAdapter
import ru.mirea.lab6.util.DataChangedListener

class MainRvFragment: Fragment() {

    private lateinit var itemClick: (Int) -> Unit

    companion object {
        fun newInstance(onItemClick: (Int) -> Unit) = MainRvFragment().apply { itemClick = onItemClick }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v: View = inflater.inflate(R.layout.fragment_rv_main, container, false)
        val adapter = MainRvAdapter(itemClick)
        val listener: DataChangedListener = object : DataChangedListener { override fun notifyDataChanged() = adapter.notifyDataSetChanged() }
        ItemService.getInstance()?.addDataChangedListener(listener)
        v.main_recycler.layoutManager = LinearLayoutManager(context)
        v.main_recycler.adapter = adapter
        return v
    }

}