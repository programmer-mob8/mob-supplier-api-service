package com.project.libs.data.source.network.datasource.supplier

import com.project.libs.base.ApiResponse
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
import retrofit2.Response

interface SupplierApiDataSource {
    suspend fun getSuppliers(
        token: String,
        queryParams: GetSupplierListParamsRequest
    ): Response<SupplierListResponse>

    suspend fun getSupplierById(
        token: String,
        id: String
    ): Response<GetSupplierByIdResponse>

    suspend fun editStatusSupplier(
        token: String,
        body: EditSupplierStatusBodyRequest
    ): Response<Unit>

    suspend fun createSupplier(
        token: String,
        body: CreateEditSupplierBodyRequest
    ): Response<CreateSupplierResponse>

    suspend fun editSupplier(
        token: String,
        id: String,
        body: CreateEditSupplierBodyRequest
    ): Response<Unit>

    suspend fun getChangelog(
        token: String,
        queryParams: GetChangelogQueryParamsRequest
    ): Response<GetChangelogListResponse>

    suspend fun deleteSupplier(
        token: String,
        body: DeleteSupplierBodyRequest
    ): Response<ApiResponse<Unit>>

    suspend fun getFilterListOption(
        token: String,
    ): Response<GetFilterListOptionResponse>

    suspend fun getChangelogOption(
        token: String,
    ): Response<GetChangelogFilterOptionResponse>
}