package com.project.libs.data.source.network.model.request

import com.google.gson.annotations.SerializedName

data class DeleteSupplierBodyRequest(
    @SerializedName("supplierID")
    val supplierID: List<String> = listOf(),
)