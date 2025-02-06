package com.project.libs.data.source.network.model.response


import com.google.gson.annotations.SerializedName

data class GetChangelogListResponse(
    @SerializedName("data")
    val `data`: Data = Data(),
    @SerializedName("message")
    val message: String = "",
    @SerializedName("status")
    val status: Int = 0
) {
    data class Data(
        @SerializedName("totalRecords")
        val totalRecords: Int = 0,
        @SerializedName("data")
        val `data`: List<Data?> = listOf()
    ) {
        data class Data(
            @SerializedName("_id")
            val id: String = "",
            @SerializedName("action")
            val action: String = "",
            @SerializedName("field")
            val `field`: String = "",
            @SerializedName("oldValue")
            val oldValue: String = "",
            @SerializedName("newValue")
            val newValue: String = "",
            @SerializedName("modifiedBy")
            val modifiedBy: String = "",
            @SerializedName("Object")
            val objectX: String = "",
            @SerializedName("objectName")
            val objectName: String = "",
            @SerializedName("timeStamps")
            val timeStamps: String = ""
        )
    }
}