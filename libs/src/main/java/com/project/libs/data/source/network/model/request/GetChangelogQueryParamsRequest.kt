package com.project.libs.data.source.network.model.request

data class GetChangelogQueryParamsRequest(
    val search: String? = null,
    val action: String? = null,
    val field: String? = null,
    val modifiedBy: String? = null,
    val page: Number? = null,
    val limit: Number? = null,
    val date: String? = null,
    val sortOrder: Boolean? = null,
    val sortBy: String? = null
) {
    fun toQueryMap(): Map<String, String?> {
        return mapOf(
            "search" to search,
            "action" to action,
            "field" to field,
            "modifiedBy" to modifiedBy,
            "page" to page.toString(),
            "date" to date.toString(),
            "limit" to limit.toString(),
            "sortOrder" to sortOrder.toString(),
            "sortBy" to sortBy

        ).filterValues { it != null }
    }
}