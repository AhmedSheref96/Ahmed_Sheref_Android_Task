package com.el3asas.ahmed_sheref_android_task.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

data class ProductsResponse(

    @Json(name = "total")
    val total: Int? = null,

    @Json(name = "limit")
    val limit: Int? = null,

    @Json(name = "skip")
    val skip: Int? = null,

    @Json(name = "products")
    val products: List<ProductsItem?>? = null
)

@Parcelize
data class ProductsItem(

    @Json(name = "discountPercentage")
    val discountPercentage: Double? = null,

    @Json(name = "thumbnail")
    val thumbnail: String? = null,

    @Json(name = "images")
    val images: List<String?>? = null,

    @Json(name = "price")
    val price: Int? = null,

    @Json(name = "rating")
    val rating: Double? = null,

    @Json(name = "description")
    val description: String? = null,

    @Json(name = "id")
    val id: Int? = null,

    @Json(name = "title")
    val title: String? = null,

    @Json(name = "stock")
    val stock: Int? = null,

    @Json(name = "category")
    val category: String? = null,

    @Json(name = "brand")
    val brand: String? = null
) : Parcelable