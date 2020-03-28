package com.mirea.laba2.util.navigator

import android.content.Intent
import com.mirea.laba2.ui.MainActivity
import com.mirea.laba2.ui.base.activity.BaseActivity
import javax.inject.Inject

class NavigatorImpl @Inject constructor(
    val activity: BaseActivity
): Navigator {

    override fun openMainScreen() = activity.startActivity(Intent(activity, MainActivity::class.java).apply {
        flags = (Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK))
    })

}