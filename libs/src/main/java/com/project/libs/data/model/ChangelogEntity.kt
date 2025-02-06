package com.project.libs.data.model

data class ChangelogEntity(
    val id: String = "",
    val action: String = "",
    val field: String = "",
    val oldValue: String = "",
    val newValue: String = "",
    val modifiedBy: String = "",
    val objectX: String = "",
    val objectName: String = "",
    val timeStamp: String = "",
)