package com.project.libs.data.mapper

import android.R.attr.data
import com.project.libs.data.model.ChangelogFilterEntity
import com.project.libs.data.model.FilterListOptionEntity
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse
import javax.inject.Inject

class FilterMapper @Inject constructor() {

    fun mapSupplierOption(data: GetFilterListOptionResponse.Data.SupplierOption): FilterListOptionEntity.SupplierOption {
        return FilterListOptionEntity.SupplierOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapCityOption(data: GetFilterListOptionResponse.Data.CityOption): FilterListOptionEntity.CityOption {
        return FilterListOptionEntity.CityOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapItemNameOption(data: GetFilterListOptionResponse.Data.ItemNameOption): FilterListOptionEntity.ItemNameOption {
        return FilterListOptionEntity.ItemNameOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapModifiedByOption(data: GetFilterListOptionResponse.Data.ModifiedByOption): FilterListOptionEntity.ModifiedByOption {
        return FilterListOptionEntity.ModifiedByOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapStatusOption(data: GetFilterListOptionResponse.Data.StatusOption): FilterListOptionEntity.StatusOption {
        return FilterListOptionEntity.StatusOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapFilterListOption(data: GetFilterListOptionResponse.Data): FilterListOptionEntity {
        return FilterListOptionEntity(
            supplierOption = data.supplierOption.map { mapSupplierOption(it) },
            cityOption = data.cityOption.map { mapCityOption(it) },
            itemNameOption = data.itemNameOption.map { mapItemNameOption(it) },
            modifiedByOption = data.modifiedByOption.map { mapModifiedByOption(it) },
            statusOption = data.statusOption.map { mapStatusOption(it) }
        )
    }

    fun mapActionOption(data: GetChangelogFilterOptionResponse.Data.ActionOption): ChangelogFilterEntity.ActionOption {
        return ChangelogFilterEntity.ActionOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapFieldOption(data: GetChangelogFilterOptionResponse.Data.FieldOption): ChangelogFilterEntity.FieldOption {
        return ChangelogFilterEntity.FieldOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapModifiedByOption(data: GetChangelogFilterOptionResponse.Data.ModifiedByOption): ChangelogFilterEntity.ModifiedByOption {
        return ChangelogFilterEntity.ModifiedByOption(
            label = data.label,
            value = data.value
        )
    }

    fun mapChangelogOption(data: GetChangelogFilterOptionResponse.Data): ChangelogFilterEntity {
        return ChangelogFilterEntity(
            actionOption = data.actionOption.map { mapActionOption(it) },
            fieldOption = data.fieldOption.map { mapFieldOption(it) },
            modifiedByOption = data.modifiedByOption.map { mapModifiedByOption(it) }
        )
    }
}