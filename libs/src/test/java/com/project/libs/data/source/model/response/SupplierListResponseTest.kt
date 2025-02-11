package com.project.libs.data.source.model.response

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.source.network.model.response.SupplierListResponse
import kotlinx.coroutines.test.runTest
import org.junit.Test

class SupplierListResponseTest {

    @Test
    fun `verify default values`() = runTest {
        // Act
        val response = SupplierListResponse()

        // Assert
        assertThat(response.message).isEqualTo("")
        assertThat(response.status).isEqualTo(0)
        assertThat(response.data.totalRecords).isEqualTo(0)
        assertThat(response.data.data).isEmpty()
    }

    @Test
    fun `verify object initialization`() = runTest {
        // Arrange
        val suppliers = listOf(SupplierEntity(id = "1", companyName = "Supplier 1"))
        val supplierDataList = suppliers.map { SupplierListResponse.Data.Data(it.id, it.companyName) }
        val response = SupplierListResponse(
            data = SupplierListResponse.Data(
                totalRecords = suppliers.size,
                data = supplierDataList
            ),
            message = "Success",
            status = 200
        )

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.totalRecords).isEqualTo(supplierDataList.size)
        assertThat(response.data.data).containsExactlyElementsIn(supplierDataList)
    }

    @Test
    fun `verify json serialization` () = runTest {
        // Arrange
        val suppliers = listOf(SupplierEntity(id = "1", companyName = "Supplier 1"))
        val supplierDataList = suppliers.map { SupplierListResponse.Data.Data(it.id, it.companyName) }
        val response = SupplierListResponse(
            data = SupplierListResponse.Data(
                totalRecords = suppliers.size,
                data = supplierDataList
            ),
            message = "Success",
            status = 200
        )

        // Act
        val gson = Gson()

        val json = gson.toJson(response)

        // Assert
        val expectedJson = """{"data":{"totalRecords":1,"data":[{"_id":"1","companyName":"Supplier 1","item":[],"country":"","state":"","city":"","picName":"","status":false,"modifiedBy":"","created_at":"","updated_at":""}]},"message":"Success","status":200}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify json deserialization`() = runTest {
        // Arrange
        val json = """{"data":{"totalRecords":1,"data":[{"_id":"1","companyName":"Supplier 1"}]},"message":"Success","status":200}"""
        val gson = Gson()

        // Act
        val response = gson.fromJson(json, SupplierListResponse::class.java)

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.totalRecords).isEqualTo(1)
        assertThat(response.data.data).hasSize(1)
        assertThat(response.data.data[0].id).isEqualTo("1")
        assertThat(response.data.data[0].companyName).isEqualTo("Supplier 1")
    }

}