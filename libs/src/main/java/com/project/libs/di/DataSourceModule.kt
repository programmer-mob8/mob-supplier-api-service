package com.project.libs.di

import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSource
import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSourceImp
import com.project.libs.data.source.network.services.SupplierApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideSupplierDataSource(supplierApi: SupplierApi): SupplierApiDataSource {
        return SupplierApiDataSourceImp(supplierApi = supplierApi)
    }
}