package com.project.libs.data.model

data class FilterListOptionEntity(
    val supplierOption: List<SupplierOption> = emptyList(),
    val cityOption: List<CityOption>,
    val itemNameOption: List<ItemNameOption>,
    val modifiedByOption: List<ModifiedByOption>,
    val statusOption: List<StatusOption>
) {
    data class SupplierOption(
        val label: String,
        val value: String
    )

    data class CityOption(
        val label: String,
        val value: String
    )

    data class ItemNameOption(
        val label: String,
        val value: String
    )

    data class ModifiedByOption(
        val label: String,
        val value: String
    )

    data class StatusOption(
        val label: String,
        val value: Boolean
    )
}