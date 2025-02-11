package com.project.libs.data.source.model.response

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.response.CreateSupplierResponse
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CreateSupplierResponseTest {


    @Test
    fun `verify default values`() = runTest {
        // Act
        val response = CreateSupplierResponse()

        // Assert
        assertThat(response.data).isNull()
        assertThat(response.message).isEqualTo("")
        assertThat(response.status).isEqualTo(0)
    }

    @Test
    fun `verify object initialization`() = runTest {
        // Act
        val response = CreateSupplierResponse(data = "Supplier Data", message = "Supplier created successfully", status = 201)

        // Assert
        assertThat(response.data).isEqualTo("Supplier Data")
        assertThat(response.message).isEqualTo("Supplier created successfully")
        assertThat(response.status).isEqualTo(201)
    }

    fun `verify json serialization`() = runTest {
        // Arrange
        val response = CreateSupplierResponse(data = "Supplier Data", message = "Supplier created successfully", status = 201)
        val gson = Gson()

        // Act
        val json = gson.toJson(response)

        // Assert
        val expectedJson = """{"data":"Supplier Data","message":"Supplier created successfully","status":201}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify JSON deserialization`() = runTest {
        // Arrange
        val json = """{"data":"Supplier Data","message":"Supplier created successfully","status":201}"""
        val gson = Gson()

        // Act
        val response = gson.fromJson(json, CreateSupplierResponse::class.java)

        // Assert
        assertThat(response.data).isEqualTo("Supplier Data")
        assertThat(response.message).isEqualTo("Supplier created successfully")
        assertThat(response.status).isEqualTo(201)
    }

}