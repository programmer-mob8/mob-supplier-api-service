package com.project.libs.data.source.model.request

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class CreateEditSupplierBodyRequestTest {

    @Test
    fun `verify default values`() = runTest {
        // Act
        val request = CreateEditSupplierBodyRequest()

        // Assert
        assertThat(request.companyName).isEqualTo("")
        assertThat(request.item).isEmpty()
        assertThat(request.country).isNull()
        assertThat(request.state).isNull()
        assertThat(request.city).isNull()
        assertThat(request.zipCode).isNull()
        assertThat(request.companyLocation).isNull()
        assertThat(request.companyPhoneNumber).isNull()
        assertThat(request.picName).isNull()
        assertThat(request.picPhoneNumber).isNull()
        assertThat(request.picEmail).isNull()
    }

    @Test
    fun `verify object initialization`() = runTest {
        // Arrange
        val items = listOf(CreateEditSupplierBodyRequest.Item(itemName = "Item 1", sku = listOf("SKU1")))

        // Act
        val request = CreateEditSupplierBodyRequest(
            companyName = "Company Name",
            item = items,
            country = "Country",
            state = "State",
            city = "City",
            zipCode = "ZipCode",
            companyLocation = "Company Location",
            companyPhoneNumber = "Company Phone Number",
            picName = "PIC Name",
            picPhoneNumber = "PIC Phone Number",
            picEmail = "PIC Email"
        )

        // Assert
        assertThat(request.companyName).isEqualTo("Company Name")
        assertThat(request.item).isEqualTo(items)
        assertThat(request.country).isEqualTo("Country")
        assertThat(request.state).isEqualTo("State")
        assertThat(request.city).isEqualTo("City")
        assertThat(request.zipCode).isEqualTo("ZipCode")
        assertThat(request.companyLocation).isEqualTo("Company Location")
        assertThat(request.companyPhoneNumber).isEqualTo("Company Phone Number")
        assertThat(request.picName).isEqualTo("PIC Name")
        assertThat(request.picPhoneNumber).isEqualTo("PIC Phone Number")
        assertThat(request.picEmail).isEqualTo("PIC Email")
    }

    @Test
    fun `verify json serialization`() = runTest {
        // Arrange
        val items = listOf(CreateEditSupplierBodyRequest.Item(itemName = "Item 1", sku = listOf("SKU1")))
        val request = CreateEditSupplierBodyRequest(
            companyName = "Company Name",
            item = items,
            country = "Country",
            state = "State",
            city = "City",
            zipCode = "ZipCode",
            companyLocation = "Company Location",
            companyPhoneNumber = "Company Phone Number",
            picName = "PIC Name",
            picPhoneNumber = "PIC Phone Number",
            picEmail = "PIC Email"
        )
        val gson = Gson()

        // Act
        val json = gson.toJson(request)

        // Assert
        val expectedJson = """{"companyName":"Company Name","item":[{"itemName":"Item 1","sku":["SKU1"]}],"country":"Country","state":"State","city":"City","zipCode":"ZipCode","companyLocation":"Company Location","companyPhoneNumber":"Company Phone Number","picName":"PIC Name","picPhoneNumber":"PIC Phone Number","picEmail":"PIC Email"}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify JSON deserialization`() = runTest {
        // Arrange
        val json = """{"companyName":"Company Name","item":[{"itemName":"Item 1","sku":["SKU1"]}],"country":"Country","state":"State","city":"City","zipCode":"ZipCode","companyLocation":"Company Location","companyPhoneNumber":"Company Phone Number","picName":"PIC Name","picPhoneNumber":"PIC Phone Number","picEmail":"PIC Email"}"""
        val gson = Gson()

        // Act
        val request = gson.fromJson(json, CreateEditSupplierBodyRequest::class.java)

        // Assert
        assertThat(request.companyName).isEqualTo("Company Name")
        assertThat(request.item).hasSize(1)
        assertThat(request.item[0].itemName).isEqualTo("Item 1")
        assertThat(request.item[0].sku).containsExactly("SKU1")
        assertThat(request.country).isEqualTo("Country")
        assertThat(request.state).isEqualTo("State")
        assertThat(request.city).isEqualTo("City")
        assertThat(request.zipCode).isEqualTo("ZipCode")
        assertThat(request.companyLocation).isEqualTo("Company Location")
        assertThat(request.companyPhoneNumber).isEqualTo("Company Phone Number")
        assertThat(request.picName).isEqualTo("PIC Name")
        assertThat(request.picPhoneNumber).isEqualTo("PIC Phone Number")
        assertThat(request.picEmail).isEqualTo("PIC Email")
    }
}