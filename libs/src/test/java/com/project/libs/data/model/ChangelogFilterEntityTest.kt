package com.project.libs.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ChangelogFilterEntityTest {

    @Test
    fun `constructor should return correct object`() {

        // Act
        val changelogFilterEntity = ChangelogFilterEntity(
            actionOption = listOf(
                ChangelogFilterEntity.ActionOption(
                    label = "label",
                    value = "value"
                )
            ),
            fieldOption = listOf(
                ChangelogFilterEntity.FieldOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                ChangelogFilterEntity.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            )
        )

        // Assert
        assertThat(changelogFilterEntity.actionOption[0].label).isEqualTo("label")
        assertThat(changelogFilterEntity.actionOption[0].value).isEqualTo("value")
        assertThat(changelogFilterEntity.fieldOption[0].label).isEqualTo("label")
        assertThat(changelogFilterEntity.fieldOption[0].value).isEqualTo("value")
        assertThat(changelogFilterEntity.modifiedByOption[0].label).isEqualTo("label")
        assertThat(changelogFilterEntity.modifiedByOption[0].value).isEqualTo("value")
    }

    @Test
    fun `constructor should return correct object with empty list`() {

        // Act
        val changelogFilterEntity = ChangelogFilterEntity(
            actionOption = emptyList(),
            fieldOption = emptyList(),
            modifiedByOption = emptyList()
        )

        // Assert
        assertThat(changelogFilterEntity.actionOption).isEmpty()
        assertThat(changelogFilterEntity.fieldOption).isEmpty()
        assertThat(changelogFilterEntity.modifiedByOption).isEmpty()
    }

    @Test
    fun `constructor should handle multiple options`() {

        // Act
        val changelogFilterEntity = ChangelogFilterEntity(
            actionOption = listOf(
                ChangelogFilterEntity.ActionOption(label = "Action 1", value = "Value 1"),
                ChangelogFilterEntity.ActionOption(label = "Action 2", value = "Value 2")
            ),
            fieldOption = listOf(
                ChangelogFilterEntity.FieldOption(label = "Field 1", value = "Value 1"),
                ChangelogFilterEntity.FieldOption(label = "Field 2", value = "Value 2")
            ),
            modifiedByOption = listOf(
                ChangelogFilterEntity.ModifiedByOption(label = "ModifiedBy 1", value = "Value 1"),
                ChangelogFilterEntity.ModifiedByOption(label = "ModifiedBy 2", value = "Value 2")
            )
        )

        // Assert
        assertThat(changelogFilterEntity.actionOption).hasSize(2)
        assertThat(changelogFilterEntity.actionOption[0].label).isEqualTo("Action 1")
        assertThat(changelogFilterEntity.actionOption[0].value).isEqualTo("Value 1")
        assertThat(changelogFilterEntity.actionOption[1].label).isEqualTo("Action 2")
        assertThat(changelogFilterEntity.actionOption[1].value).isEqualTo("Value 2")

        assertThat(changelogFilterEntity.fieldOption).hasSize(2)
        assertThat(changelogFilterEntity.fieldOption[0].label).isEqualTo("Field 1")
        assertThat(changelogFilterEntity.fieldOption[0].value).isEqualTo("Value 1")
        assertThat(changelogFilterEntity.fieldOption[1].label).isEqualTo("Field 2")
        assertThat(changelogFilterEntity.fieldOption[1].value).isEqualTo("Value 2")

        assertThat(changelogFilterEntity.modifiedByOption).hasSize(2)
        assertThat(changelogFilterEntity.modifiedByOption[0].label).isEqualTo("ModifiedBy 1")
        assertThat(changelogFilterEntity.modifiedByOption[0].value).isEqualTo("Value 1")
        assertThat(changelogFilterEntity.modifiedByOption[1].label).isEqualTo("ModifiedBy 2")
        assertThat(changelogFilterEntity.modifiedByOption[1].value).isEqualTo("Value 2")
    }
}