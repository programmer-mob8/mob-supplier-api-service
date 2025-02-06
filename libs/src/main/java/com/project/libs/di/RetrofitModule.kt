package com.project.libs.di

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.project.libs.data.source.network.services.SupplierApi
import com.project.libs.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideSupplierApi(okHttpClient: OkHttpClient): SupplierApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(SupplierApi::class.java)
    }

    @Provides
    @Singleton
    fun provideConnectivityInterceptor(@ApplicationContext context: Context): Interceptor =
        Interceptor { chain ->
            if (!isNetworkAvailable(context)) {
                throw NoConnectivityException("No internet connection")
            }
            chain.proceed(chain.request())
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(10, java.util.concurrent.TimeUnit.MINUTES)
            .readTimeout(10, java.util.concurrent.TimeUnit.MINUTES)
            .writeTimeout(10, java.util.concurrent.TimeUnit.MINUTES)
            .retryOnConnectionFailure(true)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    class NoConnectivityException(message: String) : IOException(message)
}