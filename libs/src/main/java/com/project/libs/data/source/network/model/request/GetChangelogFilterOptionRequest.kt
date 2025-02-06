package com.project.libs.data.source.network.model.request

class GetChangelogFilterOptionRequest (
    val modifiedByOption: String? = "true",
    val actionOption: String? = "true",
    val fieldOption: String? = "true"
) {
    fun toQueryMap(): Map<String, String?> {
        return mapOf(
            "modifiedByOption" to modifiedByOption.toString(),
            "actionOption" to actionOption.toString(),
            "fieldOption" to fieldOption.toString()
        )
    }
}
