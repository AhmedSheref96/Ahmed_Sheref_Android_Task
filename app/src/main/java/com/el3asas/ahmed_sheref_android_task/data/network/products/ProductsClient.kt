package com.el3asas.ahmed_sheref_android_task.data.network.products

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductsClient @Inject constructor(private val service: ProductsService) {
    suspend fun getProducts() = withContext(Dispatchers.IO) {
        service.getProducts()
    }
}