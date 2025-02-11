package com.project.libs.data.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FilterListOptionEntityTest {

    @Test
    fun `constructor should return correct object`(){

        // Act
        val filterListOptionEntity = FilterListOptionEntity(
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

        // Assert
        assertThat(filterListOptionEntity.supplierOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.supplierOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.cityOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.cityOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.itemNameOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.itemNameOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.modifiedByOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.modifiedByOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.statusOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.statusOption[0].value).isTrue()
    }

    @Test
    fun `constructor should handle empty option`(){

            // Act
            val filterListOptionEntity = FilterListOptionEntity(
                supplierOption = emptyList(),
                cityOption = emptyList(),
                itemNameOption = emptyList(),
                modifiedByOption = emptyList(),
                statusOption = emptyList()
            )

            // Assert
            assertThat(filterListOptionEntity.supplierOption.isEmpty()).isTrue()
            assertThat(filterListOptionEntity.cityOption.isEmpty()).isTrue()
            assertThat(filterListOptionEntity.itemNameOption.isEmpty()).isTrue()
            assertThat(filterListOptionEntity.modifiedByOption.isEmpty()).isTrue()
            assertThat(filterListOptionEntity.statusOption.isEmpty()).isTrue()
    }

    @Test
    fun `constructor should handle multiple option `(){

        // Act
        val filterListOptionEntity = FilterListOptionEntity(
            cityOption = listOf(
                FilterListOptionEntity.CityOption(
                    label = "label",
                    value = "value"
                ),
                FilterListOptionEntity.CityOption(
                    label = "label",
                    value = "value"
                )
            ),
            supplierOption = listOf(
                FilterListOptionEntity.SupplierOption(
                    label = "label",
                    value = "value"
                ),
                FilterListOptionEntity.SupplierOption(
                    label = "label",
                    value = "value"
                )
            ),
            itemNameOption = listOf(
                FilterListOptionEntity.ItemNameOption(
                    label = "label",
                    value = "value"
                ),
                FilterListOptionEntity.ItemNameOption(
                    label = "label",
                    value = "value"
                )
            ),
            modifiedByOption = listOf(
                FilterListOptionEntity.ModifiedByOption(
                    label = "label",
                    value = "value"
                ),
                FilterListOptionEntity.ModifiedByOption(
                    label = "label",
                    value = "value"
                )
            ),
            statusOption = listOf(
                FilterListOptionEntity.StatusOption(
                    label = "label",
                    value = true
                ),
                FilterListOptionEntity.StatusOption(
                    label = "label",
                    value = true
                )
            )
        )

        // Assert
        assertThat(filterListOptionEntity.supplierOption).hasSize(2)
        assertThat(filterListOptionEntity.cityOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.cityOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.cityOption[1].label).isEqualTo("label")
        assertThat(filterListOptionEntity.cityOption[1].value).isEqualTo("value")

        assertThat(filterListOptionEntity.supplierOption).hasSize(2)
        assertThat(filterListOptionEntity.supplierOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.supplierOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.supplierOption[1].label).isEqualTo("label")
        assertThat(filterListOptionEntity.supplierOption[1].value).isEqualTo("value")

        assertThat(filterListOptionEntity.itemNameOption).hasSize(2)
        assertThat(filterListOptionEntity.itemNameOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.itemNameOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.itemNameOption[1].label).isEqualTo("label")
        assertThat(filterListOptionEntity.itemNameOption[1].value).isEqualTo("value")

        assertThat(filterListOptionEntity.modifiedByOption).hasSize(2)
        assertThat(filterListOptionEntity.modifiedByOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.modifiedByOption[0].value).isEqualTo("value")
        assertThat(filterListOptionEntity.modifiedByOption[1].label).isEqualTo("label")
        assertThat(filterListOptionEntity.modifiedByOption[1].value).isEqualTo("value")

        assertThat(filterListOptionEntity.statusOption).hasSize(2)
        assertThat(filterListOptionEntity.statusOption[0].label).isEqualTo("label")
        assertThat(filterListOptionEntity.statusOption[0].value).isTrue()
        assertThat(filterListOptionEntity.statusOption[1].label).isEqualTo("label")
        assertThat(filterListOptionEntity.statusOption[1].value).isTrue()


    }
}