package com.project.libs.data.model

/**
 * Data class representing a changelog entry.
 *
 * @property id The unique identifier of the changelog entry.
 * @property action The action performed in the changelog entry.
 * @property field The field that was changed in the changelog entry.
 * @property oldValue The old value of the field before the change.
 * @property newValue The new value of the field after the change.
 * @property modifiedBy The user who modified the field.
 * @property objectX The object associated with the changelog entry.
 * @property objectName The name of the object associated with the changelog entry.
 * @property timeStamp The timestamp when the change was made.
 */

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