package com.project.libs.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SupplierEntityTest {

    @Test
    fun `constructor should return default values` (){
        // Act
        val supplierEntity = SupplierEntity()

        // Assert
        assertThat(supplierEntity.id).isEqualTo("")
        assertThat(supplierEntity.companyName).isEqualTo("")
        assertThat(supplierEntity.item).isEmpty()
        assertThat(supplierEntity.country).isEqualTo("")
        assertThat(supplierEntity.state).isEqualTo("")
        assertThat(supplierEntity.city).isEqualTo("")
        assertThat(supplierEntity.zipCode).isEqualTo("")
        assertThat(supplierEntity.companyLocation).isEqualTo("")
        assertThat(supplierEntity.companyPhoneNumber).isEqualTo("")
        assertThat(supplierEntity.picName).isEqualTo("")
        assertThat(supplierEntity.picPhoneNumber).isEqualTo("")
        assertThat(supplierEntity.picEmail).isEqualTo("")
        assertThat(supplierEntity.status).isFalse()
        assertThat(supplierEntity.modifiedBy).isEqualTo("")
        assertThat(supplierEntity.createdAt).isEqualTo("")
        assertThat(supplierEntity.updatedAt).isEqualTo("")

    }

    @Test
    fun `constructor should return the correct object`(){

        // Act
        val items = listOf(
            Item(
                id = "id",
                supplierId = "supplierId",
                itemName = "itemName",
                sku = listOf(
                    "sku"
                )
            )
        )

        val supplierEntity = SupplierEntity(
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
        assertThat(supplierEntity.id).isEqualTo("id")
        assertThat(supplierEntity.companyName).isEqualTo("companyName")
        assertThat(supplierEntity.item).isEqualTo(items)
        assertThat(supplierEntity.country).isEqualTo("country")
        assertThat(supplierEntity.state).isEqualTo("state")
        assertThat(supplierEntity.city).isEqualTo("city")
        assertThat(supplierEntity.zipCode).isEqualTo("zipCode")
        assertThat(supplierEntity.companyLocation).isEqualTo("companyLocation")
        assertThat(supplierEntity.companyPhoneNumber).isEqualTo("companyPhoneNumber")
        assertThat(supplierEntity.picName).isEqualTo("picName")
        assertThat(supplierEntity.picPhoneNumber).isEqualTo("picPhoneNumber")
        assertThat(supplierEntity.picEmail).isEqualTo("picEmail")
        assertThat(supplierEntity.status).isTrue()
        assertThat(supplierEntity.modifiedBy).isEqualTo("modifiedBy")
        assertThat(supplierEntity.createdAt).isEqualTo("createdAt")
        assertThat(supplierEntity.updatedAt).isEqualTo("updatedAt")
    }

    @Test
    fun `constructor should handle given values`(){
        // Act
        val item = listOf(
            Item(
                id = "1",
                supplierId = "1",
                itemName = "buku",
                sku = listOf(
                    "tas"
                )
            )
        )
        val supplierEntity = SupplierEntity(
            id = "1",
            companyName = "ddd",
            item = item,
            country = "indo",
            state = "jawa",
            city = "jakarta",
            zipCode = "123",
            companyLocation = "jakarta",
            companyPhoneNumber = "123",
            picName = "budi",
            picPhoneNumber = "123",
            picEmail = "budi@gmail.com",
            status = false,
            modifiedBy = "budi",
            createdAt = "2021-08-01",
            updatedAt = "2021-08-01"
        )

        // Assert
        assertThat(supplierEntity.id).isEqualTo("1")
        assertThat(supplierEntity.companyName).isEqualTo("ddd")
        assertThat(supplierEntity.item).isEqualTo(item)
        assertThat(supplierEntity.country).isEqualTo("indo")
        assertThat(supplierEntity.state).isEqualTo("jawa")
        assertThat(supplierEntity.city).isEqualTo("jakarta")
        assertThat(supplierEntity.zipCode).isEqualTo("123")
        assertThat(supplierEntity.companyLocation).isEqualTo("jakarta")
        assertThat(supplierEntity.companyPhoneNumber).isEqualTo("123")
        assertThat(supplierEntity.picName).isEqualTo("budi")
        assertThat(supplierEntity.picPhoneNumber).isEqualTo("123")
        assertThat(supplierEntity.picEmail).isEqualTo("budi@gmail.com")
        assertThat(supplierEntity.status).isFalse()
        assertThat(supplierEntity.modifiedBy).isEqualTo("budi")
        assertThat(supplierEntity.createdAt).isEqualTo("2021-08-01")
        assertThat(supplierEntity.updatedAt).isEqualTo("2021-08-01")
    }
}