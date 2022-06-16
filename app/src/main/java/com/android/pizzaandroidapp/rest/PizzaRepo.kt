package com.android.pizzaandroidapp.rest

import com.android.pizzaandroidapp.domain.mapToDomainData
import com.android.pizzaandroidapp.utils.PizzaTime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface PizzaRepo {
    fun makePizza(): Flow<PizzaTime>
}

class PizzaRepoImpl(
    private val pizzaServiceApi: PizzaApi = PizzaInjection.pizzaService
) : PizzaRepo {
    override fun makePizza() = flow {
        emit(PizzaTime.LOADING)

        try {
            val response = pizzaServiceApi.makePizza()
            if (response.isSuccessful) {
                response.body()?.let { orders ->
                    emit(PizzaTime.SUCCESS(orders.networkOfPizza.mapToDomainData()))
                } ?: throw Exception("DATA IS NULL")
            } else {
                throw Exception(response.errorBody()?.string() ?: "ERROR")
            }
        } catch (e: Exception) {
            emit(PizzaTime.ERROR(e))
        }
    }
}