package com.project.libs.data.source.model.response

import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse.Data.CityOption
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse.Data.ItemNameOption
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse.Data.SupplierOption
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetFilterListOptionResponseTest {

    @Test
    fun `verify default values`() {
        // Act
        val response = GetFilterListOptionResponse()

        // Assert
        assertThat(response.message).isEqualTo("")
        assertThat(response.status).isEqualTo(0)
        assertThat(response.data.supplierOption).isEmpty()
        assertThat(response.data.cityOption).isEmpty()
        assertThat(response.data.itemNameOption).isEmpty()
    }

    @Test
    fun `verify object initialization`() {
        // Arrange
        val supplierOptions = listOf(SupplierOption(label = "Supplier 1", value = "1"))
        val cityOptions = listOf(CityOption(label = "City 1", value = "1"))
        val itemNameOptions = listOf(ItemNameOption(label = "1", value = "1"))

        // Act
        val response = GetFilterListOptionResponse(
            data = GetFilterListOptionResponse.Data(
                supplierOption = supplierOptions,
                cityOption = cityOptions,
                itemNameOption = itemNameOptions
            ),
            message = "Success",
            status = 200
        )

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.supplierOption).containsExactlyElementsIn(supplierOptions)
        assertThat(response.data.cityOption).containsExactlyElementsIn(cityOptions)
        assertThat(response.data.itemNameOption).containsExactlyElementsIn(itemNameOptions)
    }

    @Test
    fun `verify json serialization`() {
        // Arrange
        val supplierOptions = listOf(SupplierOption(label = "Supplier 1", value = "1"))
        val cityOptions = listOf(CityOption(label = "City 1", value = "1"))
        val itemNameOptions = listOf(ItemNameOption(label = "Item 1", value = "1"))
        val response = GetFilterListOptionResponse(
            data = GetFilterListOptionResponse.Data(
                supplierOption = supplierOptions,
                cityOption = cityOptions,
                itemNameOption = itemNameOptions
            ),
            message = "Success",
            status = 200
        )
        val gson = Gson()

        // Act
        val json = gson.toJson(response)

        // Assert
        val expectedJson = """{"data":{"supplierOption":[{"label":"Supplier 1","value":"1"}],"cityOption":[{"label":"City 1","value":"1"}],"itemNameOption":[{"label":"Item 1","value":"1"}],"modifiedByOption":[],"statusOption":[]},"message":"Success","status":200}"""
        assertThat(json).isEqualTo(expectedJson)
    }

    @Test
    fun `verify json deserialization`() = runTest {
        // Arrange
        val json = """{"data":{"supplierOption":[{"label":"Supplier 1","value":"1"}],"cityOption":[{"label":"City 1","value":"1"}],"itemNameOption":[{"label":"Item 1","value":"1"}]},"message":"Success","status":200}"""
        val gson = Gson()

        // Act
        val response = gson.fromJson(json, GetFilterListOptionResponse::class.java)

        // Assert
        assertThat(response.message).isEqualTo("Success")
        assertThat(response.status).isEqualTo(200)
        assertThat(response.data.supplierOption).hasSize(1)
        assertThat(response.data.supplierOption[0].label).isEqualTo("Supplier 1")
        assertThat(response.data.cityOption).hasSize(1)
        assertThat(response.data.cityOption[0].label).isEqualTo("City 1")
        assertThat(response.data.itemNameOption).hasSize(1)
        assertThat(response.data.itemNameOption[0].label).isEqualTo("Item 1")
    }


}