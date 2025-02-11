package com.project.libs.domain

import com.google.common.truth.Truth.assertThat
import com.project.libs.base.ApiResponse
import com.project.libs.base.Result
import com.project.libs.data.model.ChangelogEntity
import com.project.libs.data.model.ChangelogFilterEntity
import com.project.libs.data.model.FilterListOptionEntity
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.repository.supplier.SupplierRepository
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import com.project.libs.domain.supplier.CreateSupplierUseCase
import com.project.libs.domain.supplier.DeleteSupplierUseCase
import com.project.libs.domain.supplier.EditSupplierStatusUseCase
import com.project.libs.domain.supplier.EditSupplierUseCase
import com.project.libs.domain.supplier.GetChangelogOptionUseCase
import com.project.libs.domain.supplier.GetChangelogUseCase
import com.project.libs.domain.supplier.GetFilterListOptionUseCase
import com.project.libs.domain.supplier.GetSupplierByIdUseCase
import com.project.libs.domain.supplier.SupplierUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Test


class SupplierUseCaseTest {


    // SupplierUseCase
    private val supplierRepository: SupplierRepository = mockk()
    private val supplierUseCase = SupplierUseCase(supplierRepository)

    @Test
    fun `invoke returns supplier list`() = runTest {

        // Arrange
        val query = GetSupplierListParamsRequest()
        val expected = listOf(
            SupplierEntity(
                id = "id",
                companyName = "companyName",
                item = listOf(),
                country = "country",
                state = "state",
                city = "city",
                zipCode = "zipCode",
                companyLocation = "companyLocation",
                companyPhoneNumber = "companyPhoneNumber",
                picName = "picName",
                picPhoneNumber = "picPhoneNumber",
                picEmail = "picEmail",
                status = false,
                modifiedBy = "modifiedBy",
                createdAt = "createdAt",
                updatedAt = "updatedAt"
            )
        )

        coEvery { supplierRepository.getSupplier(query) } returns flowOf(Result.Success(expected))

        // Act
        val result = supplierUseCase(query).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)

        coVerify { supplierRepository.getSupplier(query) }
    }

    @Test
    fun `invoke returns empty supplier list when no suppliers found`() = runTest {
        // Arrange
        val query = GetSupplierListParamsRequest()
        coEvery { supplierRepository.getSupplier(query) } returns flowOf(Result.Success(emptyList()))

        // Act
        val result = supplierUseCase(query).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEmpty()

        coVerify { supplierRepository.getSupplier(query) }
    }


    // GetSupplierByIdUseCase
    private val getSupplierByIdUseCase = GetSupplierByIdUseCase(supplierRepository)

    @Test
    fun `invoke returns supplier data when supplier exists`() = runTest {
        // Arrange
        val supplierId = "supplierId"
        val expected = SupplierEntity(
            id = supplierId,
            companyName = "companyName",
            item = listOf(),
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
            status = false,
            modifiedBy = "modifiedBy",
            createdAt = "createdAt",
            updatedAt = "updatedAt",
        )

        coEvery { supplierRepository.getSupplierById(supplierId) } returns flowOf(
            Result.Success(
                expected
            )
        )

        // Act
        val result = getSupplierByIdUseCase(supplierId).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.getSupplierById(supplierId) }
    }

    @Test
    fun `invoke returns error when supplier is not found`() = runTest {
        // Arrange
        val supplierId = "NoId"
        val expected = "Supplier not found"

        coEvery { supplierRepository.getSupplierById(supplierId) } returns flowOf(
            Result.Error(
                expected
            )
        )

        // Act
        val result = getSupplierByIdUseCase(supplierId).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo(expected)

        coVerify { supplierRepository.getSupplierById(supplierId) }
    }


    // EditSupplierStatusUseCase
    private val editSupplierStatusUseCase = EditSupplierStatusUseCase(supplierRepository)

    @Test
    fun `invoke return success when status is successfully updated`() = runTest {
        // Arrange
        val body = EditSupplierStatusBodyRequest(
            supplierID = listOf("supplierId"),
            status = true
        )

        coEvery { supplierRepository.editStatusSupplier(body) } returns flowOf(Result.Success(Unit))

        // Act
        val result = editSupplierStatusUseCase(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(Unit)

        coVerify { supplierRepository.editStatusSupplier(body) }
    }

    @Test
    fun `invoke returns error when supplier not found`() = runTest {
        // Arrange
        val body = EditSupplierStatusBodyRequest(
            supplierID = listOf("NoId"),
            status = true
        )
        val expected = "Supplier not found"

        coEvery { supplierRepository.editStatusSupplier(body) } returns flowOf(Result.Error(expected))

        // Act
        val result = editSupplierStatusUseCase(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo(expected)

        coVerify { supplierRepository.editStatusSupplier(body) }
    }


    // CreateSupplierUseCase
    private val createSupplierUseCase = CreateSupplierUseCase(supplierRepository)

    @Test
    fun `invoke returns success when supplier is successfully created`() = runTest {
        // Arrange
        val body = CreateEditSupplierBodyRequest(
            companyName = "companyName",
            item = listOf(
                CreateEditSupplierBodyRequest.Item(
                    itemName = "itemName",
                    sku = listOf("sku")
                )
            ),
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
        )

        coEvery { supplierRepository.createSupplier(body) } returns flowOf(Result.Success(Unit))

        // Act
        val result = createSupplierUseCase(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(Unit)

        coVerify { supplierRepository.createSupplier(body) }
    }

    @Test
    fun `invoke return error when there is an invalid data`() = runTest {
        // Arrange
        val body = CreateEditSupplierBodyRequest(
            companyName = "",
            item = listOf(
                CreateEditSupplierBodyRequest.Item(
                    itemName = "",
                    sku = listOf("")
                )
            ),
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
        )
        val expected = "Invalid data"

        coEvery { supplierRepository.createSupplier(body) } returns flowOf(Result.Error(expected))

        // Act
        val result = createSupplierUseCase(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo(expected)

        coVerify { supplierRepository.createSupplier(body) }
    }


    // EditSupplierUseCase
    private val editSupplierUseCase = EditSupplierUseCase(supplierRepository)

    @Test
    fun `invoke return success when supplier is successfully edited`() = runTest {
        // Arrange
        val supplierId = "supplierId"
        val body = CreateEditSupplierBodyRequest(
            companyName = "companyName",
            item = listOf(
                CreateEditSupplierBodyRequest.Item(
                    itemName = "itemName",
                    sku = listOf("sku")
                )
            ),
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
        )

        coEvery { supplierRepository.editSupplier(supplierId, body) } returns flowOf(
            Result.Success(
                Unit
            )
        )

        // Act
        val result = editSupplierUseCase(supplierId, body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(Unit)

        coVerify { supplierRepository.editSupplier(supplierId, body) }
    }

    @Test
    fun `invoke returns when supplier not found`() = runTest {
        val supplierId = "NoId"
        val body = CreateEditSupplierBodyRequest(
            companyName = "companyName",
            item = listOf(
                CreateEditSupplierBodyRequest.Item(
                    itemName = "itemName",
                    sku = listOf("sku")
                )
            ),
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
        )

        val expected = "supplier not found"

        coEvery { supplierRepository.editSupplier(supplierId, body) } returns flowOf(
            Result.Error(
                expected
            )
        )

        // Act
        val result = editSupplierUseCase(supplierId, body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo(expected)

        coVerify { supplierRepository.editSupplier(supplierId, body) }
    }

    @Test
    fun `invoke return error when supplier data is invalid`() = runTest {
        // Arrange
        val supplierId = "supplierId"
        val body = CreateEditSupplierBodyRequest(
            companyName = "",
            item = listOf(
                CreateEditSupplierBodyRequest.Item(
                    itemName = "",
                    sku = listOf("")
                )
            ),
            country = "country",
            state = "state",
            city = "city",
            zipCode = "zipCode",
            companyLocation = "companyLocation",
            companyPhoneNumber = "companyPhoneNumber",
            picName = "picName",
            picPhoneNumber = "picPhoneNumber",
            picEmail = "picEmail",
        )
        val expected = "Invalid data"

        coEvery { supplierRepository.editSupplier(supplierId, body) } returns flowOf(
            Result.Error(
                expected
            )
        )

        // Act
        val result = editSupplierUseCase(supplierId, body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo(expected)

        coVerify { supplierRepository.editSupplier(supplierId, body) }
    }


    // ChangelogUseCase
    private val changelogUseCase = GetChangelogUseCase(supplierRepository)

    @Test
    fun `invoke return changelog list`() = runTest {
        // Arrange
        val query = GetChangelogQueryParamsRequest()
        val expected = listOf(
            ChangelogEntity(
                id = "id",
                action = "action",
                field = "field",
                oldValue = "oldValue",
                newValue = "newValue",
                modifiedBy = "modifiedBy",
                objectX = "objectX",
                objectName = "objectName",
                timeStamp = "timeStamp"
            )
        )

        coEvery { supplierRepository.getChangelog(query) } returns flowOf(Result.Success(expected))

        // Act
        val result = changelogUseCase(query).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.getChangelog(query) }
    }

    @Test
    fun `invoke return empty changelog list when no changelog found`() = runTest {
        // Arrange
        val query = GetChangelogQueryParamsRequest()
        coEvery { supplierRepository.getChangelog(query) } returns flowOf(Result.Success(emptyList()))

        // Act
        val result = changelogUseCase(query).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEmpty()

        coVerify { supplierRepository.getChangelog(query) }
    }


    // DeleteSupplierUseCase
    private val deleteSupplierUseCase = DeleteSupplierUseCase(supplierRepository)

    @Test
    fun `invoke return success when supplier is successfully deleted`() = runTest {
        // Arrange
        val body = DeleteSupplierBodyRequest(
            supplierID = listOf("supplierId")
        )

        val expected = ApiResponse(Unit)

        coEvery { supplierRepository.deleteSupplier(body) } returns flowOf(Result.Success(expected))

        // Act
        val result = deleteSupplierUseCase(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.deleteSupplier(body) }
    }

    @Test
    fun `invoke return error when supplier not found`() = runTest {
        // Arrange
        val body = DeleteSupplierBodyRequest(
            supplierID = listOf("NoId")
        )

        val expected = "Supplier not found"

        coEvery { supplierRepository.deleteSupplier(body) } returns flowOf(Result.Error(expected))

        // Act
        val result = deleteSupplierUseCase(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo(expected)

        coVerify { supplierRepository.deleteSupplier(body) }
    }


    // GetFilterListOptionUseCase
    private val getFilterListOptionUseCase = GetFilterListOptionUseCase(supplierRepository)

    @Test
    fun `invoke return filter list option`() = runTest {
        // Arrange
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
                    value = false
                )
            )
        )

        coEvery { supplierRepository.getFilterListOption() } returns flowOf(Result.Success(expected))

        // Act
        val result = getFilterListOptionUseCase().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.getFilterListOption() }
    }

    @Test
    fun `invoke return empty list when filter data is empty`() = runTest {
        // Arrange
        val expected = FilterListOptionEntity(
            supplierOption = emptyList(),
            cityOption = emptyList(),
            itemNameOption = emptyList(),
            modifiedByOption = emptyList(),
            statusOption = emptyList()
        )

        coEvery { supplierRepository.getFilterListOption() } returns flowOf(Result.Success(expected))

        // Act
        val result = getFilterListOptionUseCase().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.getFilterListOption() }
    }



    // getChangelogOptionUseCase
    private val getChangelogOptionUseCase = GetChangelogOptionUseCase(supplierRepository)
    @Test
    fun `invoke return changelog option`() = runTest {
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

        coEvery { supplierRepository.getChangelogOption() } returns flowOf(Result.Success(expected))

        // Act
        val result = getChangelogOptionUseCase().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.getChangelogOption() }
    }

    @Test
    fun `invoke return empty changelog option when no data found`() = runTest {
        val expected = ChangelogFilterEntity(
            actionOption = emptyList(),
            fieldOption = emptyList(),
            modifiedByOption = emptyList()
        )

        coEvery { supplierRepository.getChangelogOption() } returns flowOf(Result.Success(expected))

        // Act
        val result = getChangelogOptionUseCase().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success).data).isEqualTo(expected)

        coVerify { supplierRepository.getChangelogOption() }
    }
}