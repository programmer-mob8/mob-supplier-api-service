package com.project.libs.data.source.datasource

import com.google.common.truth.Truth.assertThat
import com.project.libs.base.ApiResponse
import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSource
import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSourceImp
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.request.GetChangelogFilterOptionRequest
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import com.project.libs.data.source.network.model.request.GetFilterListOptionRequest
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import com.project.libs.data.source.network.model.response.CreateSupplierResponse
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse
import com.project.libs.data.source.network.model.response.GetChangelogListResponse
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse
import com.project.libs.data.source.network.model.response.GetSupplierByIdResponse
import com.project.libs.data.source.network.model.response.SupplierListResponse
import com.project.libs.data.source.network.services.SupplierApi
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import retrofit2.Response

class SupplierApiDataSourceTest {

    private lateinit var supplierApiDataSource: SupplierApiDataSource
    private lateinit var supplierApi: SupplierApi

    @Before
    fun setUp() {
        supplierApi = mock(SupplierApi::class.java)
        supplierApiDataSource = SupplierApiDataSourceImp(supplierApi)
    }

    // Test for getSuppliers
    @Test
    fun `getSuppliers success return SupplierListResponse`() = runTest {
        // Arrange
        val token = "token"
        val queryParams = GetSupplierListParamsRequest()
        val response = Response.success(SupplierListResponse())
        `when`(supplierApi.getSuppliers(token, queryParams.toQueryMap())).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getSuppliers(token, queryParams)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `getSuppliers error to return SupplierListResponse`() = runTest {
        // Arrange
        val token = "token"
        val queryParams = GetSupplierListParamsRequest()
        val response = Response.error<SupplierListResponse>(400, "".toResponseBody())
        `when`(supplierApi.getSuppliers(token, queryParams.toQueryMap())).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getSuppliers(token, queryParams)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for getSupplierById
    @Test
    fun `getSupplierById success return GetSupplierByIdResponse`() = runTest {
        // Arrange
        val token = "token"
        val id = "id"
        val response = Response.success(GetSupplierByIdResponse())
        `when`(supplierApi.getSupplierById(token, id)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getSupplierById(token, id)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `getSupplierById error to return GetSupplierByIdResponse`() = runTest {
        // Arrange
        val token = "token"
        val id = "id"
        val response = Response.error<GetSupplierByIdResponse>(400, "".toResponseBody())
        `when`(supplierApi.getSupplierById(token, id)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getSupplierById(token, id)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for editStatusSupplier
    @Test
    fun `editStatusSupplier success return Unit`() = runTest {
        // Arrange
        val token = "token"
        val body = EditSupplierStatusBodyRequest()
        val response = Response.success(Unit)
        `when`(supplierApi.editStatusSupplier(token, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.editStatusSupplier(token, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `editStatusSupplier error to return Unit`() = runTest {
        // Arrange
        val token = "token"
        val body = EditSupplierStatusBodyRequest()
        val response = Response.error<Unit>(400, "".toResponseBody())
        `when`(supplierApi.editStatusSupplier(token, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.editStatusSupplier(token, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for createSupplier
    @Test
    fun `createSupplier success return CreateSupplierResponse`() = runTest {
        // Arrange
        val token = "token"
        val body = CreateEditSupplierBodyRequest()
        val response = Response.success(CreateSupplierResponse())
        `when`(supplierApi.createSupplier(token, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.createSupplier(token, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `createSupplier error to return CreateSupplierResponse`() = runTest {
        // Arrange
        val token = "token"
        val body = CreateEditSupplierBodyRequest()
        val response = Response.error<CreateSupplierResponse>(400, "".toResponseBody())
        `when`(supplierApi.createSupplier(token, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.createSupplier(token, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for editSupplier
    @Test
    fun `editSupplier success return Unit`() = runTest {
        // Arrange
        val token = "token"
        val id = "id"
        val body = CreateEditSupplierBodyRequest()
        val response = Response.success(Unit)
        `when`(supplierApi.editSupplier(token, id, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.editSupplier(token, id, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `editSupplier error to return Unit`() = runTest {
        // Arrange
        val token = "token"
        val id = "id"
        val body = CreateEditSupplierBodyRequest()
        val response = Response.error<Unit>(400, "".toResponseBody())
        `when`(supplierApi.editSupplier(token, id, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.editSupplier(token, id, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for getChangelog
    @Test
    fun `getChangelog success return GetChangelogListResponse`() = runTest {
        // Arrange
        val token = "token"
        val queryParams = GetChangelogQueryParamsRequest()
        val response = Response.success(GetChangelogListResponse())
        `when`(supplierApi.getChangelog(token, queryParams.toQueryMap())).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getChangelog(token, queryParams)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `getChangelog error to return GetChangelogListResponse`() = runTest {
        // Arrange
        val token = "token"
        val queryParams = GetChangelogQueryParamsRequest()
        val response = Response.error<GetChangelogListResponse>(400, "".toResponseBody())
        `when`(supplierApi.getChangelog(token, queryParams.toQueryMap())).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getChangelog(token, queryParams)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for deleteSupplier
    @Test
    fun `deleteSupplier success return Unit`() = runTest {
        // Arrange
        val token = "token"
        val body = DeleteSupplierBodyRequest()
        val response = Response.success(ApiResponse(Unit))
        `when`(supplierApi.deleteSupplier(token, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.deleteSupplier(token, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `deleteSupplier error to return Unit`() = runTest {
        // Arrange
        val token = "token"
        val body = DeleteSupplierBodyRequest()
        val response = Response.error<ApiResponse<Unit>>(400, "".toResponseBody())
        `when`(supplierApi.deleteSupplier(token, body)).thenReturn(response)

        // Act
        val result = supplierApiDataSource.deleteSupplier(token, body)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for getFilterListOption
    @Test
    fun `getFilterListOption success return GetFilterListOptionResponse`() = runTest {
        // Arrange
        val token = "token"
        val response = Response.success(GetFilterListOptionResponse())
        `when`(
            supplierApi.getFilterListOption(
                token,
                GetFilterListOptionRequest().toQueryMap()
            )
        ).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getFilterListOption(token)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `getFilterListOption error to return GetFilterListOptionResponse`() = runTest {
        // Arrange
        val token = "token"
        val response = Response.error<GetFilterListOptionResponse>(400, "".toResponseBody())
        `when`(
            supplierApi.getFilterListOption(
                token,
                GetFilterListOptionRequest().toQueryMap()
            )
        ).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getFilterListOption(token)

        // Assert
        assertThat(result).isEqualTo(response)
    }


    // Test for getChangelogOption
    @Test
    fun `getChangelogOption success return GetChangelogListResponse`() = runTest {
        // Arrange
        val token = "token"
        val response = Response.success(GetChangelogFilterOptionResponse())
        `when`(
            supplierApi.getChangelogOption(
                token,
                GetChangelogFilterOptionRequest().toQueryMap()
            )
        ).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getChangelogOption(token)

        // Assert
        assertThat(result).isEqualTo(response)
    }

    @Test
    fun `getChangelogOption error to return GetChangelogListResponse`() = runTest {
        // Arrange
        val token = "token"
        val response = Response.error<GetChangelogFilterOptionResponse>(400, "".toResponseBody())
        `when`(
            supplierApi.getChangelogOption(
                token,
                GetChangelogFilterOptionRequest().toQueryMap()
            )
        ).thenReturn(response)

        // Act
        val result = supplierApiDataSource.getChangelogOption(token)

        // Assert
        assertThat(result).isEqualTo(response)
    }
}