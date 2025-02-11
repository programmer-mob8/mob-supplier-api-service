package com.project.libs.data.mapper

import com.project.libs.data.model.ChangelogEntity
import com.project.libs.data.model.Item
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.source.network.model.response.GetChangelogListResponse
import com.project.libs.data.source.network.model.response.GetSupplierByIdResponse
import com.project.libs.data.source.network.model.response.SupplierListResponse
import javax.inject.Inject

class SupplierMapper @Inject constructor() {

    private fun mapItem(item: SupplierListResponse.Data.Data.Item): Item {
        return Item(
            sku = item.sku,
            id = item.id,
            supplierId = item.supplierId,
            itemName = item.itemName,
        )
    }

    fun mapSuppliers(data: List<SupplierListResponse.Data.Data>): List<SupplierEntity> {
        return data.map {
            SupplierEntity(
                id = it.id,
                companyName = it.companyName,
                item = it.item.map { mapItem(it) },
                country = it.country,
                state = it.state,
                picName = it.picName,
                updatedAt = it.updatedAt,
                status = it.status
            )
        }
    }

    fun mapSupplier(data: GetSupplierByIdResponse.Data): SupplierEntity {
        return SupplierEntity(
            id = data.id,
            companyName = data.companyName,
            item = data.item.map { mapItems(it) },
            country = data.country,
            state = data.state,
            city = data.city,
            zipCode = data.zipCode,
            companyLocation = data.companyLocation,
            companyPhoneNumber = data.companyPhoneNumber,
            picName = data.picName,
            picPhoneNumber = data.picPhoneNumber,
            picEmail = data.picEmail,
            status = data.status,
            modifiedBy = data.modifiedBy,
            createdAt = data.createdAt,
            updatedAt = data.updatedAt,
        )
    }

    private fun mapItems(item: GetSupplierByIdResponse.Data.Item): Item {
        return Item(
            id = item.id,
            supplierId = item.supplierId,
            itemName = item.itemName,
            sku = item.sku
        )
    }

    fun mapChangelog(data: List<GetChangelogListResponse.Data.Data>): List<ChangelogEntity> {
        return data.map {
            ChangelogEntity(
                id = it.id,
                action = it.action,
                field = it.field,
                oldValue = it.oldValue,
                newValue = it.newValue,
                modifiedBy = it.modifiedBy,
                objectX = it.objectX,
                objectName = it.objectName,
                timeStamp = it.timeStamps,
            )
        }
    }
}