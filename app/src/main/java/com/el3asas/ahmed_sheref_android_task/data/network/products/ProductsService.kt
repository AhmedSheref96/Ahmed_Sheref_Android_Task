package com.el3asas.ahmed_sheref_android_task.data.network.products

import com.el3asas.ahmed_sheref_android_task.models.ProductsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProductsService {

    @GET("products")
    suspend fun getProducts(): Response<ProductsResponse>

}