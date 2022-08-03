package com.el3asas.ahmed_sheref_android_task.ui.home

import com.el3asas.ahmed_sheref_android_task.data.local.Pref
import com.el3asas.ahmed_sheref_android_task.data.network.products.ProductsClient
import com.el3asas.utils.utils.Response
import com.el3asas.utils.utils.safeCall
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val client: ProductsClient,
    private val pref: Pref?
) {
    suspend fun getProductsData() = safeCall {
        val response = client.getProducts()
        when (response.isSuccessful) {
            true -> {
                return@safeCall Response.Success(response.body())
            }
            else -> {
                return@safeCall Response.Error(response.raw().message)
            }
        }
    }

    val userName = pref?.userName

    fun logout(onLogout: () -> Unit) {
        pref?.clearAll()
        onLogout()
    }

}