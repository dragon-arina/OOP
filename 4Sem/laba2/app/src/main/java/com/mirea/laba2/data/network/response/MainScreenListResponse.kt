package com.mirea.laba2.data.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainScreenListResponse(
    @SerializedName("graphic") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("helptext") val helpText: String?
): Parcelable