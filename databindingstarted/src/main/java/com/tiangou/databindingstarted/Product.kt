package com.tiangou.databindingstarted

import java.math.BigDecimal

data class Product(
        var title: String,
        var description: String,
        var image: Int,
        var price: BigDecimal,
        var sale_price: BigDecimal,
        var num_ratings: Int,
        var rating: BigDecimal,
        var serial_number: Int,
        var quantity: String,
        var imageUrl: String) {



    fun hasSalePrice(): Boolean {
        val salePrice = sale_price.toDouble()
        return if (salePrice > 0) {
            true
        } else {
            false
        }
    }
}

