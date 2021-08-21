package com.stockbit.model

import com.google.gson.annotations.SerializedName

data class CryptoResponse(
    @SerializedName("CoinInfo")
    val coinInfo: CoinInfoResponse,
    @SerializedName("RAW")
    val raw: RawResponse
)