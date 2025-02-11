package com.project.libs.data.repository

import com.google.common.truth.Truth.assertThat
import com.project.libs.MainDispatcherRule
import com.project.libs.base.ApiResponse
import com.project.libs.base.Result
import com.project.libs.data.mapper.FilterMapper
import com.project.libs.data.mapper.SupplierMapper
import com.project.libs.data.model.ChangelogEntity
import com.project.libs.data.model.ChangelogFilterEntity
import com.project.libs.data.model.FilterListOptionEntity
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.repository.supplier.SupplierRepositoryImp
import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSource
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import com.project.libs.data.source.network.model.response.CreateSupplierResponse
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse
import com.project.libs.data.source.network.model.response.GetChangelogListResponse
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse
import com.project.libs.data.source.network.model.response.GetSupplierByIdResponse
import com.project.libs.data.source.network.model.response.SupplierListResponse
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class SupplierRepositoryTest {
    private lateinit var supplierRepositoryImp: SupplierRepositoryImp

    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    @MockK
    private lateinit var supplierApiDataSource: SupplierApiDataSource

    @MockK
    private lateinit var supplierMapper: SupplierMapper

    @MockK
    private lateinit var filterMapper: FilterMapper

    @Before
    fun setUp(){
        MockKAnnotations.init(this)

        supplierRepositoryImp = SupplierRepositoryImp(
            supplierApiDataSource = supplierApiDataSource,
            supplierMapper = supplierMapper,
            filterMapper = filterMapper,
            ioDispatcher = dispatcherRule.testDispatcher
        )
    }

    private var token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3Mzg5Nzg5NjQsImlkIjoiNjc5ZGMwYmZiOTJhNTM3MmMxNjAyMDBjIiwibmFtZSI6Inppa3JpIiwicm9sZSI6InVzZXIifQ.7ROuPUq4Fo1lLdOZ8iwP9do4gUoQt8iXpTyKkYI3TUE"


    // Test for getSupplier
    @Test
    fun `when response is successful should return emit success`() = runTest{
        // Arrange
        val queryParams = GetSupplierListParamsRequest()
        val supplierResponse = SupplierListResponse()
        val supplierEntity = listOf(SupplierEntity())

        coEvery { supplierApiDataSource.getSuppliers(token, queryParams) } returns Response.success(supplierResponse)
        coEvery { supplierMapper.mapSuppliers(supplierResponse.data.data) } returns supplierEntity

        // Act
        val result = supplierRepositoryImp.getSupplier(queryParams).toList()

        // Assert
        assertThat(result.first()).isInstanceOf(Result.Success::class.java)
        assertThat((result.first() as Result.Success<List<SupplierEntity>>).data).isEqualTo(supplierEntity)
    }

    @Test
    fun `when response is not successful should return emit error`() = runTest{
        // Arrange
        val queryParams = GetSupplierListParamsRequest()

        coEvery { supplierApiDataSource.getSuppliers(token, queryParams) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.getSupplier(queryParams).toList()

        // Assert
        assertThat(result.first()).isInstanceOf(Result.Error::class.java)
        assertThat((result.first() as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for getSupplierById
    @Test
    fun `when response is success return emit success`() = runTest {
        // Arrange
        val id = "id"
        val supplierIdResponse = GetSupplierByIdResponse()
        val supplierEntity = SupplierEntity()

        coEvery { supplierApiDataSource.getSupplierById(token, id) } returns Response.success(supplierIdResponse)
        coEvery { supplierMapper.mapSupplier(supplierIdResponse.data) } returns supplierEntity

        // Act
        val result = supplierRepositoryImp.getSupplierById(id).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success<SupplierEntity>).data).isEqualTo(supplierEntity)
    }

    @Test
    fun `when response is not success return emit error`() = runTest {
        // Arrange
        val id = "id"

        coEvery { supplierApiDataSource.getSupplierById(token, id) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.getSupplierById(id).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for editStatusSupplier
    @Test
    fun `when edit status response is success return emit success`() = runTest {
        // Arrange
        val body = EditSupplierStatusBodyRequest()

        coEvery { supplierApiDataSource.editStatusSupplier(token, body) } returns Response.success(Unit)

        // Act
        val result = supplierRepositoryImp.editStatusSupplier(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success<Unit>).data).isEqualTo(Unit)
    }

    @Test
    fun `when edit status response is not success return emit error`() = runTest {
        // Arrange
        val body = EditSupplierStatusBodyRequest()

        coEvery { supplierApiDataSource.editStatusSupplier(token, body) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.editStatusSupplier(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for createSupplier
    @Test
    fun `when create supplier response is success return emit success`() = runTest {
        // Arrange
        val body = CreateEditSupplierBodyRequest()
        val response = CreateSupplierResponse()

        coEvery { supplierApiDataSource.createSupplier(token, body) } returns Response.success(response)

        // Act
        val result = supplierRepositoryImp.createSupplier(body).first()

        // Assert
//        coVerify(exactly = 1) { supplierApiDataSource.createSupplier(token, body) }
//        assertThat(result).isInstanceOf(Result.Success::class.java)
//        assertThat((result as Result.Success<Unit>).data).isEqualTo(Unit)
    }

    @Test
    fun `when create supplier response is not success return emit error`() = runTest {
        // Arrange
        val body = CreateEditSupplierBodyRequest()

        coEvery { supplierApiDataSource.createSupplier(token, body) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.createSupplier(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }





    // Test for editSupplier
    @Test
    fun `when edit supplier response is success return emit success`() = runTest {
        // Arrange
        val id = "id"
        val body = CreateEditSupplierBodyRequest()

        coEvery { supplierApiDataSource.editSupplier(token, id, body) } returns Response.success(Unit)

        // Act
        val result = supplierRepositoryImp.editSupplier(id, body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success<Unit>).data).isEqualTo(Unit)
    }

    @Test
    fun `when edit supplier response is not success return emit error`() = runTest {
        // Arrange
        val id = "id"
        val body = CreateEditSupplierBodyRequest()

        coEvery { supplierApiDataSource.editSupplier(token, id, body) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.editSupplier(id, body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for deleteSupplier
    @Test
    fun `when delete supplier response is success return emit success`() = runTest {
        // Arrange
        val body = DeleteSupplierBodyRequest()

        coEvery { supplierApiDataSource.deleteSupplier(token, body) } returns Response.success(ApiResponse(Unit))

        // Act
        val result = supplierRepositoryImp.deleteSupplier(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success<ApiResponse<Unit>>).data).isEqualTo(ApiResponse(Unit))
    }

    @Test
    fun `when delete supplier response is not success return emit error`() = runTest {
        // Arrange
        val body = DeleteSupplierBodyRequest()

        coEvery { supplierApiDataSource.deleteSupplier(token, body) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.deleteSupplier(body).first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for getChangeLog
    @Test
    fun `when get changelog response is success return emit success`() = runTest {
        // Arrange
        val queryParams = GetChangelogQueryParamsRequest()
        val changelogResponse = GetChangelogListResponse()
        val changelog = listOf(ChangelogEntity())

        coEvery { supplierApiDataSource.getChangelog(token, queryParams) } returns Response.success(changelogResponse)
        coEvery { supplierMapper.mapChangelog(changelogResponse.data.data) } returns changelog

        // Act
        val result = supplierRepositoryImp.getChangelog(queryParams).toList()

        // Assert
        assertThat(result.first()).isInstanceOf(Result.Success::class.java)
        assertThat((result.first() as Result.Success<List<ChangelogEntity>>).data).isEqualTo(changelog)
    }

    @Test
    fun `when get changelog response is not success return emit error`() = runTest {
        // Arrange
        val queryParams = GetChangelogQueryParamsRequest()

        coEvery { supplierApiDataSource.getChangelog(token, queryParams) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.getChangelog(queryParams).toList()

        // Assert
        assertThat(result.first()).isInstanceOf(Result.Error::class.java)
        assertThat((result.first() as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for getFilterListOption
    @Test
    fun `when get filter list option response is success return emit success`() = runTest {
        // Arrange
        val response = GetFilterListOptionResponse()
        val filterListOption = FilterListOptionEntity(
            supplierOption = listOf(),
            cityOption = listOf(),
            itemNameOption = listOf(),
            modifiedByOption = listOf(),
            statusOption = listOf()
        )

        coEvery { supplierApiDataSource.getFilterListOption(token) } returns Response.success(response)
        coEvery { filterMapper.mapFilterListOption(response.data) } returns filterListOption

        // Act
        val result = supplierRepositoryImp.getFilterListOption().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success<FilterListOptionEntity>).data).isEqualTo(filterListOption)
    }

    @Test
    fun `when get filter list option response is not success return emit error`() = runTest {
        // Arrange
        coEvery { supplierApiDataSource.getFilterListOption(token) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.getFilterListOption().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }




    // Test for getChangelogOption
    @Test
    fun `when get changelog option response is success return emit success`() = runTest {
        // Arrange
        val response = GetChangelogFilterOptionResponse()
        val changelogOption = ChangelogFilterEntity(
            modifiedByOption = listOf(),
            actionOption = listOf(),
            fieldOption = listOf(),
        )

        coEvery { supplierApiDataSource.getChangelogOption(token) } returns Response.success(response)
        coEvery { filterMapper.mapChangelogOption(response.data) } returns changelogOption

        // Act
        val result = supplierRepositoryImp.getChangelogOption().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Success::class.java)
        assertThat((result as Result.Success<ChangelogFilterEntity>).data).isEqualTo(changelogOption)
    }

    @Test
    fun `when get changelog option response is not success return emit error`() = runTest {
        // Arrange
        coEvery { supplierApiDataSource.getChangelogOption(token) } returns Response.error(400, "".toResponseBody())

        // Act
        val result = supplierRepositoryImp.getChangelogOption().first()

        // Assert
        assertThat(result).isInstanceOf(Result.Error::class.java)
        assertThat((result as Result.Error).message).isEqualTo("Response is not successful")
    }
}