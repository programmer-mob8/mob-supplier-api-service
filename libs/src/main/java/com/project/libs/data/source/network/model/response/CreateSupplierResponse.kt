package com.project.libs.data.source.network.model.response


import com.google.gson.annotations.SerializedName

data class CreateSupplierResponse(
    @SerializedName("data")
    val `data`: Any? = null,
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Int = 0
)