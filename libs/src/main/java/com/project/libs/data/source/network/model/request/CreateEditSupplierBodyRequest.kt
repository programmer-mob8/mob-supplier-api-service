package com.project.libs.data.source.network.model.request


import com.google.gson.annotations.SerializedName

data class CreateEditSupplierBodyRequest(
    @SerializedName("companyName")
    val companyName: String = "",
    @SerializedName("item")
    val item: List<Item> = listOf(),
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("zipCode")
    val zipCode: String? = null,
    @SerializedName("companyLocation")
    val companyLocation: String? = null,
    @SerializedName("companyPhoneNumber")
    val companyPhoneNumber: String? = null,
    @SerializedName("picName")
    val picName: String? = null,
    @SerializedName("picPhoneNumber")
    val picPhoneNumber: String? = null,
    @SerializedName("picEmail")
    val picEmail: String? = null
) {
    data class Item(
        @SerializedName("itemName")
        val itemName: String = "",
        @SerializedName("sku")
        val sku: List<String> = listOf()
    )
}