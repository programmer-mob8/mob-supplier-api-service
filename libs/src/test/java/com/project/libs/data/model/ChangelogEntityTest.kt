package com.project.libs.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ChangelogEntityTest {
    @Test
    fun `constructor should return correct object`(){
        // Act
        val changelogEntity = ChangelogEntity(
            id = "id",
            action = "action",
            field = "field",
            oldValue = "oldValue",
            newValue = "newValue",
            modifiedBy = "modifiedBy",
            objectX = "objectX",
            objectName = "objectName",
            timeStamp = "timeStamp"
        )

        // Assert
        assertThat(changelogEntity.id).isEqualTo("id")
        assertThat(changelogEntity.action).isEqualTo("action")
        assertThat(changelogEntity.field).isEqualTo("field")
        assertThat(changelogEntity.oldValue).isEqualTo("oldValue")
        assertThat(changelogEntity.newValue).isEqualTo("newValue")
        assertThat(changelogEntity.modifiedBy).isEqualTo("modifiedBy")
        assertThat(changelogEntity.objectX).isEqualTo("objectX")
        assertThat(changelogEntity.objectName).isEqualTo("objectName")
        assertThat(changelogEntity.timeStamp).isEqualTo("timeStamp")
    }
}