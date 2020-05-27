package ru.mirea.lab6.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*
import ru.mirea.lab6.R
import ru.mirea.lab6.ui.admin.AdminActivity
import ru.mirea.lab6.ui.cart.CartActivity
import ru.mirea.lab6.ui.main.fragments.MainRvFragment
import ru.mirea.lab6.ui.main.fragments.MainVpFragment

class MainActivity : FragmentActivity() {

    companion object {
        const val TAG_1 = "RECYCLER_FRAGMENT"
        const val TAG_2 = "VIEW_PAGER_FRAGMENT"
    }

    private lateinit var mainRecyclerFragment: MainRvFragment
    private lateinit var mainViewPagerFragment: MainVpFragment

    private val onItemClick: (Int) -> Unit = { position ->
        mainViewPagerFragment = MainVpFragment.newInstance(position)
        supportFragmentManager.beginTransaction().replace(R.id.main_frame, mainViewPagerFragment, TAG_2).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainRecyclerFragment = MainRvFragment.newInstance(onItemClick)
        supportFragmentManager.beginTransaction().add(R.id.main_frame, mainRecyclerFragment, TAG_1).commit()

        cart_btn_main.setOnClickListener { startActivity(Intent(this@MainActivity, CartActivity::class.java)) }

        admin_btn_main.setOnClickListener { startActivity(Intent(this@MainActivity, AdminActivity::class.java)) }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentByTag(TAG_2) != null) {
            mainRecyclerFragment = MainRvFragment.newInstance(onItemClick)
            supportFragmentManager.beginTransaction().replace(R.id.main_frame, mainRecyclerFragment, TAG_1).commit()
        } else finish()
    }
}
