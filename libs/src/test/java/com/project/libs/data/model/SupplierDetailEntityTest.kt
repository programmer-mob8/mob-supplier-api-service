package com.project.libs.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SupplierDetailEntityTest {

    @Test
    fun `constructor should return correct object`() {

        // Arrange
        val items = listOf(
            SupplierDetailEntity.Item(
                id = "id",
                supplierId = "supplierId",
                itemName = "itemName",
                sku = listOf(
                    "sku"
                )
            )
        )

        // Act
        val supplierDetailEntity = SupplierDetailEntity(
            id = "id",
            companyName = "companyName",
            item = items,
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
            status = true,
            modifiedBy = "modifiedBy",
            createdAt = "createdAt",
            updatedAt = "updatedAt"
        )

        // Assert
        assertThat(supplierDetailEntity.id).isEqualTo("id")
        assertThat(supplierDetailEntity.companyName).isEqualTo("companyName")
        assertThat(supplierDetailEntity.item).isEqualTo(items)
        assertThat(supplierDetailEntity.country).isEqualTo("country")
        assertThat(supplierDetailEntity.state).isEqualTo("state")
        assertThat(supplierDetailEntity.city).isEqualTo("city")
        assertThat(supplierDetailEntity.zipCode).isEqualTo("zipCode")
        assertThat(supplierDetailEntity.companyLocation).isEqualTo("companyLocation")
        assertThat(supplierDetailEntity.companyPhoneNumber).isEqualTo("companyPhoneNumber")
        assertThat(supplierDetailEntity.picName).isEqualTo("picName")
        assertThat(supplierDetailEntity.picPhoneNumber).isEqualTo("picPhoneNumber")
        assertThat(supplierDetailEntity.picEmail).isEqualTo("picEmail")
        assertThat(supplierDetailEntity.status).isTrue()
        assertThat(supplierDetailEntity.modifiedBy).isEqualTo("modifiedBy")
        assertThat(supplierDetailEntity.createdAt).isEqualTo("createdAt")
        assertThat(supplierDetailEntity.updatedAt).isEqualTo("updatedAt")
    }

    @Test
    fun `constructor should handle default value`() {

        // Act
        val supplierDetailEntity = SupplierDetailEntity()

        // Assert
        assertThat(supplierDetailEntity.id).isEqualTo("")
        assertThat(supplierDetailEntity.companyName).isEqualTo("")
        assertThat(supplierDetailEntity.item).isEmpty()
        assertThat(supplierDetailEntity.country).isEqualTo("")
        assertThat(supplierDetailEntity.state).isEqualTo("")
        assertThat(supplierDetailEntity.city).isEqualTo("")
        assertThat(supplierDetailEntity.zipCode).isEqualTo("")
        assertThat(supplierDetailEntity.companyLocation).isEqualTo("")
        assertThat(supplierDetailEntity.companyPhoneNumber).isEqualTo("")
        assertThat(supplierDetailEntity.picName).isEqualTo("")
        assertThat(supplierDetailEntity.picPhoneNumber).isEqualTo("")
        assertThat(supplierDetailEntity.picEmail).isEqualTo("")
        assertThat(supplierDetailEntity.status).isFalse()
        assertThat(supplierDetailEntity.modifiedBy).isEqualTo("")
        assertThat(supplierDetailEntity.createdAt).isEqualTo("")
        assertThat(supplierDetailEntity.updatedAt).isEqualTo("")
    }
}