package com.project.libs.data.repository.supplier

import android.R.attr.data
import com.project.libs.base.ApiResponse
import com.project.libs.data.mapper.SupplierMapper
import com.project.libs.data.model.SupplierEntity
import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSource
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import com.project.libs.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.project.libs.base.Result
import com.project.libs.data.mapper.FilterMapper
import com.project.libs.data.model.ChangelogEntity
import com.project.libs.data.model.ChangelogFilterEntity
import com.project.libs.data.model.FilterListOptionEntity
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.request.GetChangelogFilterOptionRequest
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import com.project.libs.data.source.network.model.request.GetFilterListOptionRequest
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import java.util.logging.Filter

class SupplierRepositoryImp @Inject constructor(
    private val supplierApiDataSource: SupplierApiDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val supplierMapper: SupplierMapper,
    private val filterMapper: FilterMapper
) : SupplierRepository {

    private val token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3Mzg5Nzg5NjQsImlkIjoiNjc5ZGMwYmZiOTJhNTM3MmMxNjAyMDBjIiwibmFtZSI6Inppa3JpIiwicm9sZSI6InVzZXIifQ.7ROuPUq4Fo1lLdOZ8iwP9do4gUoQt8iXpTyKkYI3TUE"

    override fun getSupplier(queryParams: GetSupplierListParamsRequest): Flow<Result<List<SupplierEntity>>> =
        flow{

            if (token.isNotBlank()){
                val response = supplierApiDataSource.getSuppliers(token, queryParams)
                val data = response.body()?.data?.data.orEmpty()

                if(response.isSuccessful && response.code() == 200) {
                    emit(Result.Success(supplierMapper.mapSuppliers(data)))
                } else {
                    emit(Result.Error("Response is not successful"))
                }
            } else {
                emit(Result.Error("Token is empty"))
            }
        }.catch {
            emit(Result.Error(it.message))
        }.flowOn(ioDispatcher)

    override fun getSupplierById(id: String): Flow<Result<SupplierEntity>> = flow {
        if(token.isNotBlank()) {
            val response = supplierApiDataSource.getSupplierById(token, id)
            val resData = response.body()?.data

            if(response.isSuccessful && response.code() == 200 && resData != null){
                emit(Result.Success(supplierMapper.mapSupplier(resData)))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun editStatusSupplier(body: EditSupplierStatusBodyRequest): Flow<Result<Unit>> = flow {
        if(token.isNotBlank()){
            val response = supplierApiDataSource.editStatusSupplier(token, body)
            if (response.isSuccessful && response.code() == 200) {
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun createSupplier(body: CreateEditSupplierBodyRequest): Flow<Result<Unit>> = flow {
        if(token.isNotEmpty()){
            val response = supplierApiDataSource.createSupplier(token, body)
            if(response.isSuccessful && response.code() == 201) {
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun editSupplier(
        id: String,
        body: CreateEditSupplierBodyRequest
    ): Flow<Result<Unit>> = flow {
        if(token.isNotBlank()){
            val response = supplierApiDataSource.editSupplier(token, id, body)
            if(response.isSuccessful){
                emit(Result.Success(Unit))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        }else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun getChangelog(queryParams: GetChangelogQueryParamsRequest): Flow<Result<List<ChangelogEntity>>> = flow {
        if (token.isNotBlank()){
            val response = supplierApiDataSource.getChangelog(token, queryParams)
            val data = response.body()?.data?.data.orEmpty()

            if (response.isSuccessful && response.code() == 200){
                emit(Result.Success(supplierMapper.mapChangelog(data)))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun deleteSupplier(body: DeleteSupplierBodyRequest): Flow<Result<ApiResponse<Unit>>> = flow {
        if (token.isNotBlank()){
            val response = supplierApiDataSource.deleteSupplier(token, body)
            if (response.isSuccessful && response.code() == 200 ) {
                emit(Result.Success(ApiResponse(Unit)))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun getFilterListOption(): Flow<Result<FilterListOptionEntity>> = flow {
        if (token.isNotBlank()){
            val response = supplierApiDataSource.getFilterListOption(token)
            val resData = response.body()?.data

            if (response.isSuccessful && response.code() == 200 && resData != null){
                emit(Result.Success(filterMapper.mapFilterListOption(resData)))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)

    override fun getChangelogOption(): Flow<Result<ChangelogFilterEntity>> = flow {

        if (token.isNotBlank()) {
            val response = supplierApiDataSource.getChangelogOption(token)
            val resData = response.body()?.data

            if (response.isSuccessful && response.code() == 200 && resData != null) {
                emit(Result.Success(filterMapper.mapChangelogOption(resData)))
            } else {
                emit(Result.Error("Response is not successful"))
            }
        } else {
            emit(Result.Error("Token is empty"))
        }
    }.catch {
        emit(Result.Error(it.message))
    }.flowOn(ioDispatcher)
}