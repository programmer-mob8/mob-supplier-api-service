package com.project.libs.data.source.network.datasource.supplier

import com.project.libs.base.ApiResponse
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
import com.project.libs.util.Util
import retrofit2.Response
import javax.inject.Inject

class SupplierApiDataSourceImp @Inject constructor(
    private val supplierApi: SupplierApi
): SupplierApiDataSource {
    override suspend fun getSuppliers(token: String, queryParams: GetSupplierListParamsRequest): Response<SupplierListResponse> {
        return try {
            supplierApi.getSuppliers(token, queryParams.toQueryMap())
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun getSupplierById(
        token: String,
        id: String
    ): Response<GetSupplierByIdResponse> {
        return try {
            supplierApi.getSupplierById(token, id)
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun editStatusSupplier(
        token: String,
        body: EditSupplierStatusBodyRequest
    ): Response<Unit> {
        return try {
            supplierApi.editStatusSupplier(token, body)
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun createSupplier(
        token: String,
        body: CreateEditSupplierBodyRequest
    ): Response<CreateSupplierResponse> {
        return try {
            supplierApi.createSupplier(token, body)
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun editSupplier(
        token: String,
        id: String,
        body: CreateEditSupplierBodyRequest
    ): Response<Unit> {
        return try {
            supplierApi.editSupplier(token, id, body)
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun getChangelog(
        token: String,
        queryParams: GetChangelogQueryParamsRequest
    ): Response<GetChangelogListResponse> {
        return try {
            supplierApi.getChangelog(token, queryParams.toQueryMap())
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun deleteSupplier(
        token: String,
        body: DeleteSupplierBodyRequest
    ): Response<ApiResponse<Unit>> {
        return try {
            supplierApi.deleteSupplier(token, body)
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun getFilterListOption(
        token: String,
    ): Response<GetFilterListOptionResponse> {
        return try {
            supplierApi.getFilterListOption(token, GetFilterListOptionRequest().toQueryMap())
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }

    override suspend fun getChangelogOption(
        token: String,
    ): Response<GetChangelogFilterOptionResponse> {
        return try {
            supplierApi.getChangelogOption(token, GetChangelogFilterOptionRequest().toQueryMap())
        } catch (e: Exception) {
            Util.handleApiError(e)
        }
    }
}