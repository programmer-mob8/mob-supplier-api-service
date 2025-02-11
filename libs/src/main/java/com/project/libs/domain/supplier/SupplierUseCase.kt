package com.project.libs.domain.supplier

import com.project.libs.data.repository.supplier.SupplierRepository
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import javax.inject.Inject

class SupplierUseCase @Inject constructor(
    private val repository: SupplierRepository
){
    operator fun invoke(query: GetSupplierListParamsRequest) = repository.getSupplier(query)
}

class GetSupplierByIdUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke(id: String) = repository.getSupplierById(id)
}

class EditSupplierStatusUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke(body: EditSupplierStatusBodyRequest) = repository.editStatusSupplier(body)
}

class CreateSupplierUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke(body: CreateEditSupplierBodyRequest) = repository.createSupplier(body)
}

class EditSupplierUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke(id: String, body: CreateEditSupplierBodyRequest) = repository.editSupplier(id, body)
}

class GetChangelogUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke(query: GetChangelogQueryParamsRequest) = repository.getChangelog(query)
}

class DeleteSupplierUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke(body: DeleteSupplierBodyRequest) = repository.deleteSupplier(body)
}

class GetFilterListOptionUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke() = repository.getFilterListOption()
}

class GetChangelogOptionUseCase @Inject constructor(
    private val repository: SupplierRepository
) {
    operator fun invoke() = repository.getChangelogOption()
}