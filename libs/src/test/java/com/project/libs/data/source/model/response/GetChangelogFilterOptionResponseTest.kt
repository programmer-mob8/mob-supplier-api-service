package com.project.libs.data.source.model.response

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse.Data.ModifiedByOption
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse.Data.ActionOption
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse.Data.FieldOption
import org.junit.Test

class GetChangelogFilterOptionResponseTest {

    @Test
    fun `verify default values`() {
        // Act
        val response = GetChangelogFilterOptionResponse()

        // Assert
        assertThat(response.data.actionOption).isEmpty()
        assertThat(response.data.fieldOption).isEmpty()
        assertThat(response.data.modifiedByOption).isEmpty()
        assertThat(response.message).isEqualTo("")
        assertThat(response.status).isEqualTo(0)
    }

    @Test
    fun `verify object initialization`() {
        // Arrange
        val actionOptions = listOf(ActionOption(label = "1", value = "Create"), ActionOption(label = "2", value = "Update"))
        val fieldOptions = listOf(FieldOption(label = "field1", value = "Field 1"))
        val modifiedByOptions = listOf(ModifiedByOption(label = "1", value = "1"))

        // Act
        val response = GetChangelogFilterOptionResponse(
            data = GetChangelogFilterOptionResponse.Data(
                actionOption = actionOptions,
                fieldOption = fieldOptions,
                modifiedByOption = modifiedByOptions
            ),
            message = "Success",
            status = 200
        )

        // Assert
        assertThat(response.data.actionOption).containsExactlyElementsIn(actionOptions)
        assertThat(response.data.fieldOption).containsExactlyElementsIn(fieldOptions)
        assertThat(response.data.modifiedByOption).containsExactlyElementsIn(modifiedByOptions)
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
    }

    @Test
    fun `verify json initialization`() {
        // Arrange
        val actionOptions = listOf(ActionOption(label = "1", value = "Create"))
        val fieldOptions = listOf(FieldOption(label = "field1", value = "Field 1"))
        val modifiedByOptions = listOf(ModifiedByOption(label = "1", value = "User 1"))
        val response = GetChangelogFilterOptionResponse(
            data = GetChangelogFilterOptionResponse.Data(
                actionOption = actionOptions,
                fieldOption = fieldOptions,
                modifiedByOption = modifiedByOptions
            ),
            message = "Success",
            status = 200
        )
        val gson = Gson()

        // Act
        val json = gson.toJson(response)

        // Assert
        val expectedJson = """{"data":{"actionOption":[{"label":"1","value":"Create"}],"fieldOption":[{"label":"field1","value":"Field 1"}],"modifiedByOption":[{"label":"1","value":"User 1"}]},"message":"Success","status":200}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify json deserialization`() {
        // Arrange
        val json = """{"data":{"actionOption":[{"label":"1","value":"Create"}],"fieldOption":[{"label":"field1","value":"Field 1"}],"modifiedByOption":[{"label":"1","value":"User 1"}]},"message":"Success","status":200}"""
        val gson = Gson()

        // Act
        val response = gson.fromJson(json, GetChangelogFilterOptionResponse::class.java)

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.actionOption).hasSize(1)
        assertThat(response.data.actionOption[0].label).isEqualTo("1")
        assertThat(response.data.actionOption[0].value).isEqualTo("Create")
        assertThat(response.data.fieldOption).hasSize(1)
        assertThat(response.data.fieldOption[0].label).isEqualTo("field1")
        assertThat(response.data.fieldOption[0].value).isEqualTo("Field 1")
        assertThat(response.data.modifiedByOption).hasSize(1)
        assertThat(response.data.modifiedByOption[0].label).isEqualTo("1")
        assertThat(response.data.modifiedByOption[0].value).isEqualTo("User 1")
    }

}