package com.project.libs.data.model

/**
 * Data class representing the details of a supplier.
 *
 * @property id The unique identifier of the supplier.
 * @property companyName The name of the supplier's company.
 * @property item The list of items provided by the supplier.
 * @property country The country where the supplier is located.
 * @property state The state where the supplier is located.
 * @property city The city where the supplier is located.
 * @property zipCode The zip code of the supplier's location.
 * @property companyLocation The physical location of the supplier's company.
 * @property companyPhoneNumber The phone number of the supplier's company.
 * @property picName The name of the person in charge (PIC) at the supplier's company.
 * @property picPhoneNumber The phone number of the PIC.
 * @property picEmail The email address of the PIC.
 * @property status The status of the supplier (active/inactive).
 * @property modifiedBy The user who last modified the supplier's details.
 * @property createdAt The date and time when the supplier's details were created.
 * @property updatedAt The date and time when the supplier's details were last updated.
 */
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
    /**
     * Data class representing an item provided by the supplier.
     *
     * @property id The unique identifier of the item.
     * @property supplierId The unique identifier of the supplier providing the item.
     * @property itemName The name of the item.
     * @property sku The list of SKUs (Stock Keeping Units) associated with the item.
     */
    data class Item(
        val id: String,
        val supplierId: String,
        val itemName: String,
        val sku: List<String>
    )
}