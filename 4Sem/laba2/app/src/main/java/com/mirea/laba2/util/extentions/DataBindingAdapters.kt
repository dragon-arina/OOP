package com.mirea.laba2.util.extentions

import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.textfield.TextInputLayout
import com.mirea.laba2.util.DataBindingAdapter
import java.util.HashMap

@BindingAdapter("visibility")
fun setVisibility(view: View, visible: Boolean) {
    if (visible) view.visibility = View.VISIBLE else view.visibility = View.GONE
}

@BindingAdapter("visible")
fun setVisibile(view: View, visible: Boolean) {
    if (visible) view.visibility = View.VISIBLE else view.visibility = View.INVISIBLE
}

@BindingAdapter("app:onrefresh")
fun SwipeRefreshLayout.setOnRefresh(listener: SwipeRefreshLayout.OnRefreshListener) {
    this.setOnRefreshListener(listener)
}

@BindingAdapter("app:isrefreshing")
fun SwipeRefreshLayout.setIsRefreshing(refreshing: Boolean) {
    this.isRefreshing = refreshing
}

@BindingAdapter(
    "app:datasource", "app:item_layout", "app:viewmodel", "app:hasmore", "app:horizontal",
    "app:gridspan", "app:reverse", "app:filter", requireAll = false
)
fun <T> RecyclerView.setBinding(
    data: List<T>?, itemLayout: Int?, viewmodel: Any?, hasMore: Boolean?, horizontal: Boolean = false,
    gridspan: Int = 0, reverse: Boolean = false, filter: String?
) {
    if (data != null && itemLayout != null) {
        if (adapter == null) {
            layoutManager =
                if (gridspan == 0) {
                    LinearLayoutManager(context).apply {
                        orientation =
                            if (horizontal)
                                RecyclerView.HORIZONTAL
                            else
                                RecyclerView.VERTICAL
                    }
                } else
                    GridLayoutManager(context, gridspan)

            if (reverse && layoutManager is LinearLayoutManager) {
                (layoutManager as LinearLayoutManager).reverseLayout = true
                (layoutManager as LinearLayoutManager).stackFromEnd = true
            }

            adapter = DataBindingAdapter(context, itemLayout, data, {
                //onitemclick?.onClick(item)
            }, viewmodel).apply {
                this.reverse = reverse
                if (reverse)
                    scrollToPosition(0)
            }
        } else {
            (adapter as DataBindingAdapter<T>).apply {
                setNewData(data)
                //adapter?.notifyItemRangeInserted(adapter.itemCount, data.size - 1)
            }
            adapter?.notifyDataSetChanged()
        }
        if (hasMore != null)
            (adapter as DataBindingAdapter<*>?)?.hasMore = hasMore
        if (filter != null) {
            (adapter as DataBindingAdapter<*>).filter = filter
        }

    }
}

@BindingAdapter("app:itemspacing")
fun <T> RecyclerView.setItemSpacing(spacing: Float) {
    this.addItemDecoration(VerticalSpacingItemDecoration(spacing))
}

@BindingAdapter("app:onPageChangeListener")
fun ViewPager.useOnPageChangeListener(listener: ViewPager.OnPageChangeListener) {
    this.addOnPageChangeListener(listener)
}

@BindingAdapter("app:imageLink")
fun ImageView.setImageLink(link: String) {
    this.loadImage(link = link)
}


@BindingAdapter("app:url")
fun loadImage(view: ImageView?, url: String?) {
    url?.let { view?.loadWithoutCrop(url) }
}

@BindingAdapter("app:logResult")
fun View.logResult(result: Any?) {
    Log.e("Result", result.toString())
}



@BindingAdapter("app:webUrl")
fun WebView.webUrl(link: String) {
    this.loadUrl(link)
}

@BindingAdapter("app:WebViewClient")
fun WebView.webViewClient(client: WebViewClient) {
    this.webViewClient = client
}

