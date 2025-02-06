package com.project.libs.data.repository.supplier

import com.project.libs.base.ApiResponse
import com.project.libs.base.Result
import com.project.libs.data.model.ChangelogEntity
import com.project.libs.data.model.ChangelogFilterEntity
import com.project.libs.data.model.FilterListOptionEntity
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import kotlinx.coroutines.flow.Flow

interface SupplierRepository {
    fun getSupplier(queryParams: GetSupplierListParamsRequest): Flow<Result<List<SupplierEntity>>>

    fun getSupplierById(id: String): Flow<Result<SupplierEntity>>

    fun editStatusSupplier(body: EditSupplierStatusBodyRequest): Flow<Result<Unit>>

    fun createSupplier(body: CreateEditSupplierBodyRequest): Flow<Result<Unit>>

    fun editSupplier(id: String, body: CreateEditSupplierBodyRequest): Flow<Result<Unit>>

    fun getChangelog(queryParams: GetChangelogQueryParamsRequest): Flow<Result<List<ChangelogEntity>>>

    fun deleteSupplier(body: DeleteSupplierBodyRequest): Flow<Result<ApiResponse<Unit>>>

    fun getFilterListOption(): Flow<Result<FilterListOptionEntity>>

    fun getChangelogOption(): Flow<Result<ChangelogFilterEntity>>
}