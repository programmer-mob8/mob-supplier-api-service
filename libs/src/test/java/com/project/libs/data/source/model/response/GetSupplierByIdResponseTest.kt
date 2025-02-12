package com.project.libs.data.source.model.response

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.response.GetSupplierByIdResponse
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetSupplierByIdResponseTest {
    @Test
    fun `verify default values`() = runTest {
        // Act
        val response = GetSupplierByIdResponse()

        // Assert
        assertThat(response.data.id).isEqualTo("")
        assertThat(response.data.companyName).isEqualTo("")
        assertThat(response.message).isEqualTo("")
        assertThat(response.status).isEqualTo(0)
    }

    @Test
    fun `verify object initialization`() = runTest {
        // Arrange
        val supplierId = "12345"
        val companyName = "Supplier Company"
        val response = GetSupplierByIdResponse(
            data = GetSupplierByIdResponse.Data(
                id = supplierId,
                companyName = companyName
            ),
            message = "Supplier retrieved successfully",
            status = 200
        )

        // Assert
        assertThat(response.data.id).isEqualTo(supplierId)
        assertThat(response.data.companyName).isEqualTo(companyName)
        assertThat(response.message).isEqualTo("Supplier retrieved successfully")
        assertThat(response.status).isEqualTo(200)
    }

    @Test
    fun `verify json serialization`() = runTest {
        // Arrange
        val response = GetSupplierByIdResponse(
            data = GetSupplierByIdResponse.Data(
                id = "12345",
                companyName = "Supplier Company"
            ),
            message = "Supplier retrieved successfully",
            status = 200
        )
        val gson = Gson()

        // Act
        val json = gson.toJson(response)

        // Assert
        val expectedJson = """{"data":{"_id":"12345","companyName":"Supplier Company","item":[],"country":"","state":"","city":"","zipCode":"","companyLocation":"","companyPhoneNumber":"","picName":"","picPhoneNumber":"","picEmail":"","status":false,"modifiedBy":"","created_at":"","updated_at":""},"message":"Supplier retrieved successfully","status":200}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify json deserialization`() = runTest {
        // Arrange
        val json = """{"data":{"_id":"12345","companyName":"Supplier Company"},"message":"Supplier retrieved successfully","status":200}"""
        val gson = Gson()

        // Act
        val response = gson.fromJson(json, GetSupplierByIdResponse::class.java)

        // Assert
        assertThat(response.data.id).isEqualTo("12345")
        assertThat(response.data.companyName).isEqualTo("Supplier Company")
        assertThat(response.message).isEqualTo("Supplier retrieved successfully")
        assertThat(response.status).isEqualTo(200)
    }

    @Test
    fun `verify empty item list`() = runTest {
        val response = GetSupplierByIdResponse(
            data = GetSupplierByIdResponse.Data(
                id = "12345",
                companyName = "Supplier Company",
                item = listOf()
            ),
            message = "Supplier retrieved successfully",
            status = 200
        )

        assertThat(response.data.item).isEmpty()
    }

    @Test
    fun `verify non-empty item list`() = runTest {
        val item = GetSupplierByIdResponse.Data.Item(
            id = "item1",
            supplierId = "12345",
            itemName = "Item Name",
            sku = listOf("sku1", "sku2")
        )
        val response = GetSupplierByIdResponse(
            data = GetSupplierByIdResponse.Data(
                id = "12345",
                companyName = "Supplier Company",
                item = listOf(item)
            ),
            message = "Supplier retrieved successfully",
            status = 200
        )

        assertThat(response.data.item).hasSize(1)
        assertThat(response.data.item[0].id).isEqualTo("item1")
        assertThat(response.data.item[0].supplierId).isEqualTo("12345")
        assertThat(response.data.item[0].itemName).isEqualTo("Item Name")
        assertThat(response.data.item[0].sku).containsExactly("sku1", "sku2")
    }

    @Test
    fun `verify default item values`() = runTest {
        val item = GetSupplierByIdResponse.Data.Item()

        assertThat(item.id).isEqualTo("")
        assertThat(item.supplierId).isEqualTo("")
        assertThat(item.itemName).isEqualTo("")
        assertThat(item.sku).isEmpty()
    }

    @Test
    fun `verify json serialization with items`() = runTest {
        val item = GetSupplierByIdResponse.Data.Item(
            id = "item1",
            supplierId = "12345",
            itemName = "Item Name",
            sku = listOf("sku1", "sku2")
        )
        val response = GetSupplierByIdResponse(
            data = GetSupplierByIdResponse.Data(
                id = "12345",
                companyName = "Supplier Company",
                item = listOf(item)
            ),
            message = "Supplier retrieved successfully",
            status = 200
        )
        val gson = Gson()

        val json = gson.toJson(response)

        val expectedJson =
            """{"data":{"_id":"12345","companyName":"Supplier Company","item":[{"_id":"item1","supplier_id":"12345","itemName":"Item Name","sku":["sku1","sku2"]}],"country":"","state":"","city":"","zipCode":"","companyLocation":"","companyPhoneNumber":"","picName":"","picPhoneNumber":"","picEmail":"","status":false,"modifiedBy":"","created_at":"","updated_at":""},"message":"Supplier retrieved successfully","status":200}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify json deserialization with items`() = runTest {
        val json =
            """{"data":{"_id":"12345","companyName":"Supplier Company","item":[{"_id":"item1","supplier_id":"12345","itemName":"Item Name","sku":["sku1","sku2"]}]},"message":"Supplier retrieved successfully","status":200}"""
        val gson = Gson()

        val response = gson.fromJson(json, GetSupplierByIdResponse::class.java)

        assertThat(response.data.id).isEqualTo("12345")
        assertThat(response.data.companyName).isEqualTo("Supplier Company")
        assertThat(response.data.item).hasSize(1)
        assertThat(response.data.item[0].id).isEqualTo("item1")
        assertThat(response.data.item[0].supplierId).isEqualTo("12345")
        assertThat(response.data.item[0].itemName).isEqualTo("Item Name")
        assertThat(response.data.item[0].sku).containsExactly("sku1", "sku2")
        assertThat(response.message).isEqualTo("Supplier retrieved successfully")
        assertThat(response.status).isEqualTo(200)
    }
}
