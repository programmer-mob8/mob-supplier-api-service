package com.project.libs.di

import com.project.libs.data.mapper.FilterMapper
import com.project.libs.data.mapper.SupplierMapper
import com.project.libs.data.repository.supplier.SupplierRepository
import com.project.libs.data.repository.supplier.SupplierRepositoryImp
import com.project.libs.data.source.network.datasource.supplier.SupplierApiDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSupplierRepository(
        supplierApiDataSource: SupplierApiDataSource,
        supplierMapper: SupplierMapper,
        filterMapper: FilterMapper,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): SupplierRepository{
        return SupplierRepositoryImp(
            supplierMapper = supplierMapper,
            filterMapper = filterMapper,
            supplierApiDataSource = supplierApiDataSource,
            ioDispatcher = ioDispatcher
        )
    }

}