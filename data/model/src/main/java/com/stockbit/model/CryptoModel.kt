package com.stockbit.model

data class CryptoModel(
    var name: String,
    var fullName: String,
    var currentPrice: Double,
    var changePrice: Double,
    var changePricePercent: Double
)
