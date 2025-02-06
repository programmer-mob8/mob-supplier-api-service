package com.project.libs.data.source.network.services

import com.project.libs.base.ApiResponse
import com.project.libs.data.source.network.model.request.CreateEditSupplierBodyRequest
import com.project.libs.data.source.network.model.request.DeleteSupplierBodyRequest
import com.project.libs.data.source.network.model.request.EditSupplierStatusBodyRequest
import com.project.libs.data.source.network.model.response.CreateSupplierResponse
import com.project.libs.data.source.network.model.response.GetChangelogFilterOptionResponse
import com.project.libs.data.source.network.model.response.GetChangelogListResponse
import com.project.libs.data.source.network.model.response.GetFilterListOptionResponse
import com.project.libs.data.source.network.model.response.GetSupplierByIdResponse
import com.project.libs.data.source.network.model.response.SupplierListResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.HTTP
import retrofit2.http.Header
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface SupplierApi {
    @GET("/v2/supplier")
    suspend fun getSuppliers(
        @Header("Authorization") token: String,
        @QueryMap query: Map<String, String?> = mapOf()
    ): Response<SupplierListResponse>

    @GET("/v2/supplier/{id}")
    suspend fun getSupplierById(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Response<GetSupplierByIdResponse>

    @PATCH("/v2/supplier")
    suspend fun editStatusSupplier(
        @Header("Authorization") token: String,
        @Body body: EditSupplierStatusBodyRequest
    ): Response<Unit>

    @POST("/v2/supplier")
    suspend fun createSupplier(
        @Header("Authorization") token: String,
        @Body body: CreateEditSupplierBodyRequest
    ): Response<CreateSupplierResponse>

    @PUT("/v2/supplier/{id}")
    suspend fun editSupplier(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Body body: CreateEditSupplierBodyRequest
    ): Response<Unit>

    @GET("/v2/changelog")
    suspend fun getChangelog(
        @Header("Authorization") token: String,
        @QueryMap query: Map<String, String?> = mapOf()
    ): Response<GetChangelogListResponse>

    @HTTP(method = "DELETE", path = "/v2/supplier", hasBody = true)
    suspend fun deleteSupplier(
        @Header("Authorization") token: String,
        @Body body: DeleteSupplierBodyRequest
    ): Response<ApiResponse<Unit>>

    @GET("v2/supplier/option?itemNameOption=true&modifiedByOption=true&supplierOption=true&cityOption=true&statusOption=true")
    suspend fun getFilterListOption(
        @Header("Authorization") token: String,
        @QueryMap query: Map<String, String?> = mapOf()
    ): Response<GetFilterListOptionResponse>

    @GET("v2/changelog/option?modifiedByOption=true&actionOption=true&fieldOption=true")
    suspend fun getChangelogOption(
        @Header("Authorization") token: String,
        @QueryMap query: Map<String, String?> = mapOf()
    ): Response<GetChangelogFilterOptionResponse>
}