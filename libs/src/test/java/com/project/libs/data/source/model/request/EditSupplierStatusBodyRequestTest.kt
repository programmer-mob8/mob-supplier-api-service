package com.project.libs.data.source.model.request

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class EditSupplierStatusBodyRequestTest {

    @Test
    fun `verify default values`() = runTest {
        val request = EditSupplierStatusBodyRequest()
        assertThat(request.supplierID).isEmpty()
        assertThat(request.status).isFalse()
    }

    @Test
    fun `verify object initialization`() = runTest {
        val supplierIDs = listOf("Supplier1", "Supplier2")
        val request = EditSupplierStatusBodyRequest(supplierID = supplierIDs, status = true)
        assertThat(request.supplierID).isEqualTo(supplierIDs)
        assertThat(request.status).isTrue()
    }

    @Test
    fun `verify json serialization`() = runTest {
        val supplierIDs = listOf("Supplier1", "Supplier2")
        val request = EditSupplierStatusBodyRequest(supplierID = supplierIDs, status = true)
        val gson = Gson()
        val json = gson.toJson(request)
        val expectedJson = """{"supplierID":["Supplier1","Supplier2"],"status":true}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify JSON deserialization`() = runTest {
        val json = """{"supplierID":["Supplier1","Supplier2"],"status":true}"""
        val gson = Gson()
        val request = gson.fromJson(json, EditSupplierStatusBodyRequest::class.java)
        assertThat(request.supplierID).containsExactly("Supplier1", "Supplier2")
        assertThat(request.status).isTrue()
    }
}