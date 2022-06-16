package com.android.pizzaandroidapp.model

import com.google.gson.annotations.SerializedName

data class PizzaOrders(
    @SerializedName("order")
    val networkOfPizza: List<NetworkOfPizza>?
)