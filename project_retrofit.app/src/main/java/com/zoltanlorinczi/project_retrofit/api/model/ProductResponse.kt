package com.zoltanlorinczi.project_retrofit.api.model

import android.media.Image
import com.google.gson.annotations.SerializedName

/**
 * Author:  Zoltan Lorinczi
 * Date:    11/8/2021
 */
data class ProductResponse(
    @SerializedName("username")
    val rating: Double,

    @SerializedName("username")
    val amount_type: String,

    @SerializedName("username")
    val price_type: String,

    @SerializedName("username")
    val product_id: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("username")
    val is_active: Boolean,

    @SerializedName("username")
    val price_per_unit: String,

    @SerializedName("username")
    val units: String,

    @SerializedName("username")
    val description: String,

    @SerializedName("username")
    val title: String,

    @SerializedName("username")
    val images: List<Image>,

    @SerializedName("username")
    val creation_time: Long
)
