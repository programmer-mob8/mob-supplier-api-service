package com.project.libs.data.mapper

import com.google.common.truth.Truth.assertThat
import com.project.libs.data.model.ChangelogFilterEntity
import com.project.libs.data.model.FilterListOptionEntity
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse
import org.junit.Test

class FilterMapperTest {

    private var filterMapper = FilterMapper()

    @Test
    fun `when supplier option data null then return the default data`() {
        // Arrange
        val supplierOptionData = GetFilterListOptionResponse.Data.SupplierOption(
            label = "",
            value = ""
        )

        val expected = FilterListOptionEntity.SupplierOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapSupplierOption(supplierOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when city option data null then return the default data`() {
        // Arrange
        val cityOptionData = GetFilterListOptionResponse.Data.CityOption(
            label = "",
            value = ""
        )

        val expected = FilterListOptionEntity.CityOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapCityOption(cityOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when item name option data null then return the default data`() {
        // Arrange
        val itemNameOptionData = GetFilterListOptionResponse.Data.ItemNameOption(
            label = "",
            value = ""
        )

        val expected = FilterListOptionEntity.ItemNameOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapItemNameOption(itemNameOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when modified by option data null then return the default data`() {
        // Arrange
        val modifiedByOptionData = GetFilterListOptionResponse.Data.ModifiedByOption(
            label = "",
            value = ""
        )

        val expected = FilterListOptionEntity.ModifiedByOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapModifiedByOption(modifiedByOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when status option data null then return the default data`() {
        // Arrange
        val statusOptionData = GetFilterListOptionResponse.Data.StatusOption(
            label = "",
            value = false,
        )

        val expected = FilterListOptionEntity.StatusOption(
            label = "",
            value = false
        )

        // Act
        val actual = filterMapper.mapStatusOption(statusOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when filter list option data null then return the default data`() {
        // Arrange
        val filterListOptionData = GetFilterListOptionResponse.Data(
            supplierOption = listOf(),
            cityOption = listOf(),
            itemNameOption = listOf(),
            modifiedByOption = listOf(),
            statusOption = listOf()
        )

        val expected = FilterListOptionEntity(
            supplierOption = listOf(),
            cityOption = listOf(),
            itemNameOption = listOf(),
            modifiedByOption = listOf(),
            statusOption = listOf()
        )

        // Act
        val actual = filterMapper.mapFilterListOption(filterListOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when action option data changelog null then return the default data`() {
        // Arrange
        val actionOptionData = GetChangelogFilterOptionResponse.Data.ActionOption(
            label = "",
            value = ""
        )

        val expected = ChangelogFilterEntity.ActionOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapActionOption(actionOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when field option changelog data null then return the default data`() {
        // Arrange
        val fieldOptionData = GetChangelogFilterOptionResponse.Data.FieldOption(
            label = "",
            value = ""
        )

        val expected = ChangelogFilterEntity.FieldOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapFieldOption(fieldOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when modified by option changelog data null then return the default data`() {
        // Arrange
        val modifiedByOptionData = GetChangelogFilterOptionResponse.Data.ModifiedByOption(
            label = "",
            value = ""
        )

        val expected = ChangelogFilterEntity.ModifiedByOption(
            label = "",
            value = ""
        )

        // Act
        val actual = filterMapper.mapModifiedByOption(modifiedByOptionData)

        // Assert
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when changelog filter data is null then return default value`(){
        // Arrange
        val changelogFilter = GetChangelogFilterOptionResponse.Data(
            actionOption = listOf(),
            fieldOption = listOf(),
            modifiedByOption = listOf()
        )

        val expected = ChangelogFilterEntity(
            actionOption = listOf(),
            fieldOption = listOf(),
            modifiedByOption = listOf()
        )

        // Act
        val result = filterMapper.mapChangelogOption(changelogFilter)

        // Assert
        assertThat(result).isEqualTo(expected)
    }



    @Test
    fun `when supplier option data is not null then return mapped value`(){
        // Arrange
        val supplierOptionData = GetFilterListOptionResponse.Data.SupplierOption(
            label = "label",
            value = "value"
        )

        val expected = FilterListOptionEntity.SupplierOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapSupplierOption(supplierOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when city option data is not null then return mapped value`(){
        // Arrange
        val cityOptionData = GetFilterListOptionResponse.Data.CityOption(
            label = "label",
            value = "value"
        )

        val expected = FilterListOptionEntity.CityOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapCityOption(cityOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when item name option data is not null then return mapped value`(){
        // Arrange
        val itemNameOptionData = GetFilterListOptionResponse.Data.ItemNameOption(
            label = "label",
            value = "value"
        )

        val expected = FilterListOptionEntity.ItemNameOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapItemNameOption(itemNameOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when modified by option data is not null then return mapped value`(){
        // Arrange
        val modifiedByOptionData = GetFilterListOptionResponse.Data.ModifiedByOption(
            label = "label",
            value = "value"
        )

        val expected = FilterListOptionEntity.ModifiedByOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapModifiedByOption(modifiedByOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when status option data is not null then return mapped value`(){
        // Arrange
        val statusOptionData = GetFilterListOptionResponse.Data.StatusOption(
            label = "label",
            value = true
        )

        val expected = FilterListOptionEntity.StatusOption(
            label = "label",
            value = true
        )

        // Act
        val result = filterMapper.mapStatusOption(statusOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when action option data is not null then return mapped value`(){
        // Arrange
        val actionOptionData = GetChangelogFilterOptionResponse.Data.ActionOption(
            label = "label",
            value = "value"
        )

        val expected = ChangelogFilterEntity.ActionOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapActionOption(actionOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when filter option data is not null then return mapped value`(){
        // Arrange
        val filterListOptionData = GetFilterListOptionResponse.Data(
            supplierOption = listOf(
                GetFilterListOptionResponse.Data.SupplierOption(
                    label = "label",
                    value = "value"
                )
            ),
            cityOption = listOf(
                GetFilterListOptionResponse.Data.CityOption(
                    label = "label",
                    value = "value"
                )
            ),
            itemNameOption = listOf(
                GetFilterListOptionResponse.Data.ItemNameOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                GetFilterListOptionResponse.Data.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            ),
            statusOption = listOf(
                GetFilterListOptionResponse.Data.StatusOption(
                    label = "label",
                    value = true
                )
            )
        )

        val expected = FilterListOptionEntity(
            supplierOption = listOf(
                FilterListOptionEntity.SupplierOption(
                    label = "label",
                    value = "value"
                )
            ),
            cityOption = listOf(
                FilterListOptionEntity.CityOption(
                    label = "label",
                    value = "value"
                )
            ),
            itemNameOption = listOf(
                FilterListOptionEntity.ItemNameOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                FilterListOptionEntity.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            ),
            statusOption = listOf(
                FilterListOptionEntity.StatusOption(
                    label = "label",
                    value = true
                )
            )
        )

        // Act
        val result = filterMapper.mapFilterListOption(filterListOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when action option changelog data is not null then return mapped value`(){
        // Arrange
        val actionOptionData = GetChangelogFilterOptionResponse.Data.ActionOption(
            label = "label",
            value = "value"
        )

        val expected = ChangelogFilterEntity.ActionOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapActionOption(actionOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when field option changelog data is not null then return mapped value`(){
        // Arrange
        val fieldOptionData = GetChangelogFilterOptionResponse.Data.FieldOption(
            label = "label",
            value = "value"
        )

        val expected = ChangelogFilterEntity.FieldOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapFieldOption(fieldOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when modified by option changelog data is not null then return mapped value`(){
        // Arrange
        val modifiedByOptionData = GetChangelogFilterOptionResponse.Data.ModifiedByOption(
            label = "label",
            value = "value"
        )

        val expected = ChangelogFilterEntity.ModifiedByOption(
            label = "label",
            value = "value"
        )

        // Act
        val result = filterMapper.mapModifiedByOption(modifiedByOptionData)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when changelog filter data is not null then return mapped value`(){
        // Arrange
        val changelogFilter = GetChangelogFilterOptionResponse.Data(
            actionOption = listOf(
                GetChangelogFilterOptionResponse.Data.ActionOption(
                    label = "label",
                    value = "value"
                )
            ),
            fieldOption = listOf(
                GetChangelogFilterOptionResponse.Data.FieldOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                GetChangelogFilterOptionResponse.Data.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            )
        )

        val expected = ChangelogFilterEntity(
            actionOption = listOf(
                ChangelogFilterEntity.ActionOption(
                    label = "label",
                    value = "value"
                )
            ),
            fieldOption = listOf(
                ChangelogFilterEntity.FieldOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                ChangelogFilterEntity.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            )
        )

        // Act
        val result = filterMapper.mapChangelogOption(changelogFilter)

        // Assert
        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `when filter option changelog data is not null then return the mapped value`(){
        // Arrange
        val changelogFilter = GetChangelogFilterOptionResponse.Data(
            actionOption = listOf(
                GetChangelogFilterOptionResponse.Data.ActionOption(
                    label = "label",
                    value = "value"
                )
            ),
            fieldOption = listOf(
                GetChangelogFilterOptionResponse.Data.FieldOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                GetChangelogFilterOptionResponse.Data.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            )
        )

        val expected = ChangelogFilterEntity(
            actionOption = listOf(
                ChangelogFilterEntity.ActionOption(
                    label = "label",
                    value = "value"
                )
            ),
            fieldOption = listOf(
                ChangelogFilterEntity.FieldOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                ChangelogFilterEntity.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            )
        )

        // Act
        val result = filterMapper.mapChangelogOption(changelogFilter)

        // Assert
        assertThat(result).isEqualTo(expected)
    }
}