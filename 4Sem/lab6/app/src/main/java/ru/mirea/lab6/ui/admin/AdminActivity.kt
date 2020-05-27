package ru.mirea.lab6.ui.admin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_admin.*
import ru.mirea.lab6.R
import ru.mirea.lab6.ui.additem.AddItemActivity
import ru.mirea.lab6.ui.admin.fragments.AdminRvFragment
import ru.mirea.lab6.ui.admin.fragments.AdminVpFragment

class AdminActivity : FragmentActivity() {

    companion object {
        var TAG_1 = "ADMIN_RECYCLER_FRAGMENT"
        var TAG_2 = "ADMIN_VIEW_PAGER_FRAGMENT"
    }

    private lateinit var adminRecyclerFragment: AdminRvFragment
    private lateinit var adminViewPagerFragment: AdminVpFragment

    private val onClick: (Int) -> Unit = { position ->
        adminViewPagerFragment = AdminVpFragment.newInstance(position)
        supportFragmentManager.beginTransaction().replace(R.id.frame_admin, adminViewPagerFragment, TAG_2).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        adminRecyclerFragment = AdminRvFragment.newInstance(onClick)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_admin, adminRecyclerFragment, TAG_1)
        transaction.commit()
        add_btn_admin.setOnClickListener { startActivity(Intent(this@AdminActivity, AddItemActivity::class.java)) }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentByTag(TAG_2) != null) {
            adminRecyclerFragment = AdminRvFragment.newInstance(onClick)
            supportFragmentManager.beginTransaction().replace(R.id.frame_admin, adminRecyclerFragment).commit()
        } else {
            finish()
        }
    }


}
