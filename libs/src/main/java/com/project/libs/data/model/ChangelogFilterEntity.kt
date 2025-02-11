package com.project.libs.data.model

/**
 * Data class representing a filter for changelog entries.
 *
 * @property actionOption List of action options for filtering.
 * @property fieldOption List of field options for filtering.
 * @property modifiedByOption List of modified by options for filtering.
 */

data class ChangelogFilterEntity(
    val actionOption: List<ActionOption> = emptyList(),
    val fieldOption: List<FieldOption> = emptyList(),
    val modifiedByOption: List<ModifiedByOption> = emptyList()
) {

    /**
     * Data class representing an action option.
     *
     * @property label The label of the action option.
     * @property value The value of the action option.
     */
    data class ActionOption(
        val label: String,
        val value: String
    )

    /**
     * Data class representing a field option.
     *
     * @property label The label of the field option.
     * @property value The value of the field option.
     */
    data class FieldOption(
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
}