package com.project.libs.data.mapper

import com.google.common.truth.Truth.assertThat
import com.project.libs.data.model.ChangelogEntity
import com.project.libs.data.model.Item
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.source.network.model.response.GetChangelogListResponse
import com.project.libs.data.source.network.model.response.GetSupplierByIdResponse
import com.project.libs.data.source.network.model.response.SupplierListResponse
import org.junit.Test

class SupplierMapperTest {

    private var supplierMapper = SupplierMapper()

    @Test
    fun `when supplier data null then return the default data`() {

        // Arrange
        val supplierData = SupplierListResponse.Data.Data(
            id = "",
            companyName = "",
            item = listOf(
                SupplierListResponse.Data.Data.Item(
                    id = "",
                    supplierId = "",
                    itemName = "",
                    sku = listOf()
                )
            ),
            country = "",
            state = "",
            picName = "",
            updatedAt = "",
            status = false
        )

        val expected = SupplierEntity(
            id = "",
            companyName = "",
            item = listOf(
                Item(
                    id = "",
                    supplierId = "",
                    itemName = "",
                    sku = listOf()
                )
            ),
            country = "",
            state = "",
            city = "",
            zipCode = "",
            companyLocation = "",
            companyPhoneNumber = "",
            picName = "",
            picPhoneNumber = "",
            picEmail = "",
            status = false,
            modifiedBy = "",
            createdAt = "",
            updatedAt = ""
        )

        // Act
        val result = supplierMapper.mapSuppliers(listOf(supplierData))

        // Assert
        assertThat(result).isEqualTo(listOf(expected))
    }

    @Test
    fun `when supplier data not null then return the mapped data`() {

        // Arrange
        val supplierData = SupplierListResponse.Data.Data(
            id = "1",
            companyName = "Company",
            item = listOf(
                SupplierListResponse.Data.Data.Item(
                    id = "1",
                    supplierId = "1",
                    itemName = "Item",
                    sku = listOf("1")
                )
            ),
            country = "Country",
            state = "State",
            picName = "Pic",
            updatedAt = "2021-01-01",
            status = true
        )

        val expected = SupplierEntity(
            id = "1",
            companyName = "Company",
            item = listOf(
                Item(
                    id = "1",
                    supplierId = "1",
                    itemName = "Item",
                    sku = listOf("1")
                )
            ),
            country = "Country",
            state = "State",
            city = "",
            zipCode = "",
            companyLocation = "",
            companyPhoneNumber = "",
            picName = "Pic",
            picPhoneNumber = "",
            picEmail = "",
            status = true,
            modifiedBy = "",
            createdAt = "",
            updatedAt = "2021-01-01"
        )

        // Act
        val result = supplierMapper.mapSuppliers(listOf(supplierData))

        // Assert
        assertThat(result).isEqualTo(listOf(expected))
    }

    @Test
    fun `when get supplier by id data is null then return default value`(){
        // Arrange
        val supplierIdData = GetSupplierByIdResponse.Data(
            id = "",
            companyName = "",
            item = listOf(
                GetSupplierByIdResponse.Data.Item(
                    id = "",
                    supplierId = "",
                    itemName = "",
                    sku = listOf()
                )
            ),
            country = "",
            state = "",
            city = "",
            zipCode = "",
            companyLocation = "",
            companyPhoneNumber = "",
            picName = "",
            picPhoneNumber = "",
            picEmail = "",
            status = false,
            modifiedBy = "",
            createdAt = "",
            updatedAt = ""
        )

        val expected = SupplierEntity(
            id = "",
            companyName = "",
            item = listOf(
                Item(
                    id = "",
                    supplierId = "",
                    itemName = "",
                    sku = listOf()
                )
            ),
            country = "",
            state = "",
            city = "",
            zipCode = "",
            companyLocation = "",
            companyPhoneNumber = "",
            picName = "",
            picPhoneNumber = "",
            picEmail = "",
            status = false,
            modifiedBy = "",
            createdAt = "",
            updatedAt = ""
        )

        // Act
        val result = supplierMapper.mapSupplier(supplierIdData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }


    @Test
    fun `when get supplier by id data is not null then return mapped value`() {
        // Arrange
        val supplierIdData = GetSupplierByIdResponse.Data(
            id = "1",
            companyName = "Company",
            item = listOf(
                GetSupplierByIdResponse.Data.Item(
                    id = "1",
                    supplierId = "1",
                    itemName = "Item",
                    sku = listOf("1")
                )
            ),
            country = "Country",
            state = "State",
            city = "City",
            zipCode = "12345",
            companyLocation = "Location",
            companyPhoneNumber = "123456789",
            picName = "Pic",
            picPhoneNumber = "987654321",
            picEmail = "b@gmail.com",
            status = true,
            modifiedBy = "Admin",
            createdAt = "2021-01-01",
            updatedAt = "2021-01-01",
        )

        val expected = SupplierEntity(
            id = "1",
            companyName = "Company",
            item = listOf(
                Item(
                    id = "1",
                    supplierId = "1",
                    itemName = "Item",
                    sku = listOf("1")
                )
            ),
            country = "Country",
            state = "State",
            city = "City",
            zipCode = "12345",
            companyLocation = "Location",
            companyPhoneNumber = "123456789",
            picName = "Pic",
            picPhoneNumber = "987654321",
            picEmail = "b@gmail.com",
            status = true,
            modifiedBy = "Admin",
            createdAt = "2021-01-01",
            updatedAt = "2021-01-01"
        )

        // Act
        val result = supplierMapper.mapSupplier(supplierIdData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when changelog data is not null then return mapped value`(){
        // Arrange
        val changelogData = listOf(
            GetChangelogListResponse.Data.Data(
                id = "1",
                action = "Update",
                field = "Field",
                oldValue = "Old",
                newValue = "New",
                modifiedBy = "Admin",
                objectX = "Object",
                objectName = "Object Name",
                timeStamps = "2021-01-01"
            )
        )

        val expected = listOf(
            ChangelogEntity(
                id = "1",
                action = "Update",
                field = "Field",
                oldValue = "Old",
                newValue = "New",
                modifiedBy = "Admin",
                objectX = "Object",
                objectName = "Object Name",
                timeStamp = "2021-01-01"
            )
        )

        // Act
        val result = supplierMapper.mapChangelog(changelogData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }
}