package com.project.libs.data.source.network.model.request

class GetFilterListOptionRequest(
    val itemNameOption: String? = "true",
    val modifiedByOption: String? = "true",
    val supplierOption: String? = "true",
    val cityOption: String? = "true",
    val statusOption: String? = "true"
) {
    fun toQueryMap(): Map<String, String?> {
        return mapOf(
            "itemNameOption" to itemNameOption?.toString(),
            "modifiedByOption" to modifiedByOption?.toString(),
            "supplierOption" to supplierOption?.toString(),
            "cityOption" to cityOption?.toString(),
            "statusOption" to statusOption?.toString()
        )
    }
}