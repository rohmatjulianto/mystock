package com.stockbit.common.utils

import java.text.DecimalFormat

object NumberFormat {
    fun formatPriceChanges(value: Double): String {
        return DecimalFormat("##.##").format(value)
    }

    fun formatPrice(value: Double): String {
        return DecimalFormat("#,###").format(value)
    }
}