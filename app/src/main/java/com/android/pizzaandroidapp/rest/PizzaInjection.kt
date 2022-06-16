package com.android.pizzaandroidapp.rest

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PizzaInjection {

    private val pizzaClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    val pizzaService by lazy {
        Retrofit.Builder()
            .baseUrl(PizzaApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(pizzaClient)
            .build()
            .create(PizzaApi::class.java)
    }
}