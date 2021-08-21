package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class RawResponse (
    @SerializedName("IDR")
    val rawDetail : RawDetail
)

data class RawDetail(
    @SerializedName("PRICE")
    val price: Double,

    @SerializedName("CHANGEHOUR")
    val changeHour: Double,

    @SerializedName("CHANGEPCTHOUR")
    val changePCTHour: Double,
)