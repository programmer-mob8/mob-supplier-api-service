package com.project.libs.data.source.model.response

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.response.GetChangelogListResponse
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetChangelogListResponseTest {
    private val gson = Gson()

    @Test
    fun `verify object values`() = runTest {
        // Act
        val response = GetChangelogListResponse()

        // Assert
        assertThat(response.message).isEqualTo("")
        assertThat(response.status).isEqualTo(0)
        assertThat(response.data.totalRecords).isEqualTo(0)
        assertThat(response.data.data).isEmpty()
    }

    @Test
    fun `verify object initialization`() = runTest {
        // Arrange
        val changelogData = listOf(
            GetChangelogListResponse.Data.Data(id = "1", action = "Create", timeStamps = "2025-02-10T10:00:00Z"),
            GetChangelogListResponse.Data.Data(id = "2", action = "Update", timeStamps = "2025-02-11T10:00:00Z")
        )
        val response = GetChangelogListResponse(
            data = GetChangelogListResponse.Data(
                totalRecords = changelogData.size,
                data = changelogData
            ),
            message = "Success",
            status = 200
        )

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.totalRecords).isEqualTo(changelogData.size)
        assertThat(response.data.data).hasSize(changelogData.size)
        assertThat(response.data.data[0]?.id).isEqualTo("1")
        assertThat(response.data.data[0]?.action).isEqualTo("Create")
        assertThat(response.data.data[0]?.timeStamps).isEqualTo("2025-02-10T10:00:00Z")
    }

    @Test
    fun `verify json initialization`() {
        // Arrange
        val changelogData = listOf(
            GetChangelogListResponse.Data.Data(
                id = "1",
                action = "Create",
                timeStamps = "2025-02-10T10:00:00Z",
                field = "",
                oldValue = "",
                newValue = "",
                modifiedBy = "",
                objectX = "",
                objectName = ""
            )
        )
        val response = GetChangelogListResponse(
            data = GetChangelogListResponse.Data(
                totalRecords = changelogData.size,
                data = changelogData
            ),
            message = "Success",
            status = 200
        )

        // Act
        val json = gson.toJson(response)

        // Assert
        val expectedJson = """{"data":{"totalRecords":1,"data":[{"_id":"1","action":"Create","field":"","oldValue":"","newValue":"","modifiedBy":"","Object":"","objectName":"","timeStamps":"2025-02-10T10:00:00Z"}]},"message":"Success","status":200}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify json deserialization`() = runTest {
        // Arrange
        val json = """{"data":{"totalRecords":1,"data":[{"_id":"1","action":"Create","timeStamps":"2025-02-10T10:00:00Z"}]},"message":"Success","status":200}"""

        // Act
        val response = gson.fromJson(json, GetChangelogListResponse::class.java)

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.totalRecords).isEqualTo(1)
        assertThat(response.data.data).hasSize(1)
        assertThat(response.data.data[0]?.id).isEqualTo("1")
        assertThat(response.data.data[0]?.action).isEqualTo("Create")
        assertThat(response.data.data[0]?.timeStamps).isEqualTo("2025-02-10T10:00:00Z")
    }
}