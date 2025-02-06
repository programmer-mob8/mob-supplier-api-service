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
import retrofit2.Response
import javax.inject.Inject

class SupplierApiDataSourceImp @Inject constructor(
    private val supplierApi: SupplierApi
): SupplierApiDataSource {
    override suspend fun getSuppliers(token: String, queryParams: GetSupplierListParamsRequest): Response<SupplierListResponse> {
        return supplierApi.getSuppliers(token, queryParams.toQueryMap())
    }

    override suspend fun getSupplierById(
        token: String,
        id: String
    ): Response<GetSupplierByIdResponse> {
        return supplierApi.getSupplierById(token, id)
    }

    override suspend fun editStatusSupplier(
        token: String,
        body: EditSupplierStatusBodyRequest
    ): Response<Unit> {
        return supplierApi.editStatusSupplier(token, body)
    }

    override suspend fun createSupplier(
        token: String,
        body: CreateEditSupplierBodyRequest
    ): Response<CreateSupplierResponse> {
        return supplierApi.createSupplier(token, body)
    }

    override suspend fun editSupplier(
        token: String,
        id: String,
        body: CreateEditSupplierBodyRequest
    ): Response<Unit> {
        return supplierApi.editSupplier(token, id, body)
    }

    override suspend fun getChangelog(token: String, queryParams: GetChangelogQueryParamsRequest): Response<GetChangelogListResponse> {
        return supplierApi.getChangelog(token, queryParams.toQueryMap())
    }

    override suspend fun deleteSupplier(
        token: String,
        body: DeleteSupplierBodyRequest
    ): Response<ApiResponse<Unit>> {
        return supplierApi.deleteSupplier(token, body)
    }

    override suspend fun getFilterListOption(
        token: String,
    ): Response<GetFilterListOptionResponse> {
        return supplierApi.getFilterListOption(token, GetFilterListOptionRequest().toQueryMap())
    }

    override suspend fun getChangelogOption(
        token: String,
    ): Response<GetChangelogFilterOptionResponse> {
        return supplierApi.getChangelogOption(token, GetChangelogFilterOptionRequest().toQueryMap())
    }


}