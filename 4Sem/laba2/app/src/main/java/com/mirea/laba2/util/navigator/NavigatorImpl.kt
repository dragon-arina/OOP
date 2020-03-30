package com.mirea.laba2.util.navigator

import android.content.Intent
import com.mirea.laba2.data.network.response.MainScreenListResponse
import com.mirea.laba2.ui.main.MainActivity
import com.mirea.laba2.ui.base.activity.BaseActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor(
    val activity: BaseActivity
): Navigator {

    override fun openMainScreen(data: List<MainScreenListResponse>) =
        activity.startActivity(Intent(activity, MainActivity::class.java).apply {
            flags = (Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK))
            putParcelableArrayListExtra(MainActivity.ARG_LIST, ArrayList(data))
    })

}