package com.project.libs.data.source.network.model.request

data class GetSupplierListParamsRequest(
    val search: String? = null,
    val supplier: String? = null,
    val city: String? = null,
    val itemName: String? = null,
    val modifiedBy: String? = null,
    val page: Number? = null,
    val limit: Number? = null,
    val sortOrder: Boolean? = null,
    val date: String? = null,
    val status: String? = null,
    val sortBy: String? = null
) {
    fun toQueryMap(): Map<String, String?> {
        return mapOf(
            "search" to search,
            "supplier" to supplier,
            "city" to city,
            "itemName" to itemName,
            "modifiedBy" to modifiedBy,
            "page" to page?.toString(),
            "limit" to limit?.toString(),
            "sortOrder" to sortOrder?.toString(),
            "date" to date?.toString(),
            "status" to status?.toString(),
            "sortBy" to sortBy
        ).filterValues { it != null }
    }
}
