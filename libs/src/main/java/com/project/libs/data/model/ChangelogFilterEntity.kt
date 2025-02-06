package com.project.libs.data.model

data class ChangelogFilterEntity(
    val actionOption: List<ActionOption> = emptyList(),
    val fieldOption: List<FieldOption> = emptyList(),
    val modifiedByOption: List<ModifiedByOption> = emptyList()
) {
    data class ActionOption(
        val label: String,
        val value: String
    )

    data class FieldOption(
        val label: String,
        val value: String
    )

    data class ModifiedByOption(
        val label: String,
        val value: String
    )
}