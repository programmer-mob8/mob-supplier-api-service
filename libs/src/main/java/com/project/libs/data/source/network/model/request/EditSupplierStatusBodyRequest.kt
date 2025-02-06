package com.project.libs.data.source.network.model.request


import com.google.gson.annotations.SerializedName

data class EditSupplierStatusBodyRequest(
    @SerializedName("supplierID")
    val supplierID: List<String> = listOf(),
    @SerializedName("status")
    val status: Boolean = false
)