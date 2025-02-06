package com.project.libs.data.source.network.model.response


import com.google.gson.annotations.SerializedName

data class GetFilterListOptionResponse(
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Int = 0
) {
    data class Data(
        @SerializedName("supplierOption")
        val supplierOption: List<SupplierOption> = listOf(),
        @SerializedName("cityOption")
        val cityOption: List<CityOption> = listOf(),
        @SerializedName("itemNameOption")
        val itemNameOption: List<ItemNameOption> = listOf(),
        @SerializedName("modifiedByOption")
        val modifiedByOption: List<ModifiedByOption> = listOf(),
        @SerializedName("statusOption")
        val statusOption: List<StatusOption> = listOf()
    ) {
        data class SupplierOption(
            @SerializedName("label")
            val label: String = "",
            @SerializedName("value")
            val value: String = ""
        )

        data class CityOption(
            @SerializedName("label")
            val label: String = "",
            @SerializedName("value")
            val value: String = ""
        )

        data class ItemNameOption(
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

        data class StatusOption(
            @SerializedName("label")
            val label: String = "",
            @SerializedName("value")
            val value: Boolean = false
        )
    }
}