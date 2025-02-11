package com.project.libs.data.source.model.request

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class DeleteSupplierBodyRequestTest {

    @Test
    fun `verify default values`() = runTest {
        // Act
        val request = DeleteSupplierBodyRequest()

        // Assert
        assertThat(request.supplierID).isEmpty()
    }

    @Test
    fun `verify object initialization`() = runTest {
        // Arrange
        val supplierIDs = listOf("Supplier1", "Supplier2")

        // Act
        val request = DeleteSupplierBodyRequest(supplierID = supplierIDs)

        // Assert
        assertThat(request.supplierID).isEqualTo(supplierIDs)
    }

    @Test
    fun `verify json serialization`() = runTest {
        // Arrange
        val supplierIDs = listOf("Supplier1", "Supplier2")
        val request = DeleteSupplierBodyRequest(supplierID = supplierIDs)
        val gson = Gson()

        // Act
        val json = gson.toJson(request)

        // Assert
        val expectedJson = """{"supplierID":["Supplier1","Supplier2"]}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify JSON deserialization`() = runTest {
        // Arrange
        val json = """{"supplierID":["Supplier1","Supplier2"]}"""
        val gson = Gson()

        // Act
        val request = gson.fromJson(json, DeleteSupplierBodyRequest::class.java)

        // Assert
        assertThat(request.supplierID).containsExactly("Supplier1", "Supplier2")
    }
}