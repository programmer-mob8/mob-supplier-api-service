package com.project.libs.data.model

/**
 * Data class representing filter list options for various entities.
 *
 * @property supplierOption List of supplier options, default is an empty list.
 * @property cityOption List of city options.
 * @property itemNameOption List of item name options.
 * @property modifiedByOption List of modified by options.
 * @property statusOption List of status options.
 */
data class FilterListOptionEntity(
    val supplierOption: List<SupplierOption> = emptyList(),
    val cityOption: List<CityOption>,
    val itemNameOption: List<ItemNameOption>,
    val modifiedByOption: List<ModifiedByOption>,
    val statusOption: List<StatusOption>
) {
    /**
     * Data class representing a supplier option.
     *
     * @property label The label of the supplier option.
     * @property value The value of the supplier option.
     */
    data class SupplierOption(
        val label: String,
        val value: String
    )

    /**
     * Data class representing a city option.
     *
     * @property label The label of the city option.
     * @property value The value of the city option.
     */
    data class CityOption(
        val label: String,
        val value: String
    )

    /**
     * Data class representing an item name option.
     *
     * @property label The label of the item name option.
     * @property value The value of the item name option.
     */
    data class ItemNameOption(
        val label: String,
        val value: String
    )

    /**
     * Data class representing a modified by option.
     *
     * @property label The label of the modified by option.
     * @property value The value of the modified by option.
     */
    data class ModifiedByOption(
        val label: String,
        val value: String
    )

    /**
     * Data class representing a status option.
     *
     * @property label The label of the status option.
     * @property value The value of the status option.
     */
    data class StatusOption(
        val label: String,
        val value: Boolean
    )
}