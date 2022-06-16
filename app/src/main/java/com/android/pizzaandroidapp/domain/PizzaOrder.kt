package com.android.pizzaandroidapp.domain

import com.android.pizzaandroidapp.model.NetworkOfPizza

data class Order(
    val size: PriceOfPizza,
    var price: Int = 0
)

fun List<NetworkOfPizza>?.mapToDomainData(): List<Order> {
    return mutableListOf<Order>().apply {
        this@mapToDomainData?.map {
            add(
                Order(
                    size = when (it.size) {
                        "small" -> PriceOfPizza.SMALL
                        "medium" -> PriceOfPizza.MEDIUM
                        "large" -> PriceOfPizza.LARGE
                        else -> PriceOfPizza.NONE
                    },
                ).apply {
                    price = when (size) {
                        PriceOfPizza.SMALL -> size.price
                        PriceOfPizza.MEDIUM -> size.price
                        PriceOfPizza.LARGE -> size.price
                        else -> 0
                    }
                }
            )
        }
    }
}