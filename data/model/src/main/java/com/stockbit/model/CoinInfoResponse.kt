package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class CoinInfoResponse(
    @SerializedName("Name")
    val name : String,

    @SerializedName("FullName")
    val fullName : String
)