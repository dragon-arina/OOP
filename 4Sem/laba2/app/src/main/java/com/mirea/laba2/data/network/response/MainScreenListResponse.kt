package com.mirea.laba2.data.network.response

import com.google.gson.annotations.SerializedName

data class MainScreenListResponse(
    @SerializedName("graphic") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("helptext") val helpText: String?
)