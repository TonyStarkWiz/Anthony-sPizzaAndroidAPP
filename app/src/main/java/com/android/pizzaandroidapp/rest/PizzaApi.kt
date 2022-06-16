package com.android.pizzaandroidapp.rest

import com.android.pizzaandroidapp.model.PizzaOrders
import retrofit2.Response
import retrofit2.http.GET

interface PizzaApi {

    @GET(PIZZA_ORDER)
    suspend fun makePizza(): Response<PizzaOrders>

    companion object{
        const val BASE_URL = "https://raw.githubusercontent.com/pgiani/KotlinTask/main/"
        private const val PIZZA_ORDER = "order.json"
    }
}