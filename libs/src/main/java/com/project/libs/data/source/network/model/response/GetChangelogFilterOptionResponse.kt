package com.project.libs.data.source.network.model.response


import com.google.gson.annotations.SerializedName

data class GetChangelogFilterOptionResponse(
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Int = 0
) {
    data class Data(
        @SerializedName("actionOption")
        val actionOption: List<ActionOption> = listOf(),
        @SerializedName("fieldOption")
        val fieldOption: List<FieldOption> = listOf(),
        @SerializedName("modifiedByOption")
        val modifiedByOption: List<ModifiedByOption> = listOf()
    ) {
        data class ActionOption(
            @SerializedName("label")
            val label: String = "",
            @SerializedName("value")
            val value: String = ""
        )

        data class FieldOption(
            @SerializedName("label")
            val label: String = "",
            @SerializedName("value")
            val value: String = ""
        )

        data class ModifiedByOption(
            @SerializedName("label")
            val label: String = "",
            @SerializedName("value")
            val value: String = ""
        )
    }
}