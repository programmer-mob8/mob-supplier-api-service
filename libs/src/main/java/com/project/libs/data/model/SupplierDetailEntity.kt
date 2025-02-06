package com.project.libs.data.model

data class SupplierDetailEntity(
    val id: String = "",
    val companyName: String = "",
    val item: List<Item> = emptyList(),
    val country: String = "",
    val state: String = "",
    val city: String = "",
    val zipCode: String = "",
    val companyLocation: String = "",
    val companyPhoneNumber: String = "",
    val picName: String = "",
    val picPhoneNumber: String = "",
    val picEmail: String = "",
    var status: Boolean = false,
    val modifiedBy: String = "",
    val createdAt: String = "",
    val updatedAt: String = ""
) {
    data class Item(
        val id: String,
        val supplierId: String,
        val itemName: String,
        val sku: List<String>
    )
}