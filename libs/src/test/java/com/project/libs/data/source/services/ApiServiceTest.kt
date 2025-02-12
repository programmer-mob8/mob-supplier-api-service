package com.project.libs.data.source.services

import com.google.common.truth.Truth.assertThat
import com.project.libs.data.source.network.services.SupplierApi
import io.mockk.unmockkAll
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: SupplierApi
    private val token =
        "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3Mzg5Nzg5NjQsImlkIjoiNjc5ZGMwYmZiOTJhNTM3MmMxNjAyMDBjIiwibmFtZSI6Inppa3JpIiwicm9sZSI6InVzZXIifQ.7ROuPUq4Fo1lLdOZ8iwP9do4gUoQt8iXpTyKkYI3TUE"

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SupplierApi::class.java)
    }

    @After
    fun tearDown() {
        unmockkAll()
        mockWebServer.shutdown()
    }

    @Test
    fun `getChangeLog should return success response`() = runBlocking {
        // Simulasikan respons JSON dari API
        val mockResponse = MockResponse()
            .setBody(
                """
                {
                    "data": {
                   
                        "data": [
                            {
                                "id": "1",
                                "action": "UPDATE",
                                "modifiedBy": "User A",
                                "lastmodified": "2024-01-01",
                                "field": "status",
                                "oldValue": "Pending",
                                "newValue": "Approved"
                            },
                            {
                                "id": "2",
                                "action": "DELETE",
                                "modifiedBy": "User B",
                                "lastmodified": "2024-02-01",
                                "field": "price",
                                "oldValue": "1000",
                                "newValue": "0"
                            }
                        ]                
                    }
                }
            """.trimIndent()
            )
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        // Panggil API dengan query kosong
        val response = api.getChangelog(token)

        // Verifikasi hasilnya
        assertThat(response.isSuccessful).isTrue()
        assertThat(response.body()).isNotNull()
        assertThat(response.body()?.data?.data).isNotEmpty()
        assertThat(response.body()?.data?.data?.size).isEqualTo(2)
        assertThat(response.body()?.data?.data?.first()?.action).isEqualTo("UPDATE")
    }

    @Test
    fun `getSupplierList should return success response`() = runBlocking {
        // Simulasikan respons JSON dari API
        val mockResponse = MockResponse()
            .setBody(
                """
                {
                    "data": {
                        "totalRecords": 2,
                        "data": [
                            {
                                "_id": "1",
                                "companyName": "PT. A",
                                "item": [
                                    {
                                        "_id": "1",
                                        "supplier_id": "1",
                                        "itemName": "Item A",
                                        "sku": ["SKU1", "SKU2"]
                                    }
                                ],
                                "country": "Indonesia",
                                "state": "DKI Jakarta",
                                "city": "Jakarta",
                                "picName": "User A",
                                "status": true,
                                "modifiedBy": "User A",
                                "created_at": "2024-01-01",
                                "updated_at": "2024-01-01"
                            },
                            {
                                "_id": "2",
                                "companyName": "PT. B",
                                "item": [
                                    {
                                        "_id": "2",
                                        "supplier_id": "2",
                                        "itemName": "Item B",
                                        "sku": ["SKU3", "SKU4"]
                                    }
                                ],
                                "country": "Indonesia",
                                "state": "DKI Jakarta",
                                "city": "Jakarta",
                                "picName": "User B",
                                "status": true,
                                "modifiedBy": "User B",
                                "created_at": "2024-02-01",
                                "updated_at": "2024-02-01"
                            }
                        ]
                    }
                }
            """.trimIndent()
            )
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        // Panggil API dengan query kosong
        val response = api.getSuppliers(token)

        // Verifikasi hasilnya
        assertThat(response.isSuccessful).isTrue()
        assertThat(response.body()).isNotNull()
        assertThat(response.body()?.data?.data).isNotEmpty()
        assertThat(response.body()?.data?.data?.size).isEqualTo(2)
        assertThat(response.body()?.data?.data?.first()?.companyName).isEqualTo("PT. A")
    }

    @Test
    fun `getSupplierFilterListOption should return success response`() = runBlocking {
        // Simulasikan respons JSON dari API
        val mockResponse = MockResponse()
            .setBody(
                """
                {
                    "data": {
                        "supplierOption": [
                            {
                                "label": "PT. A",
                                "value": "1"
                            },
                            {
                                "label": "PT. B",
                                "value": "2"
                            }
                        ],
                        "cityOption": [
                            {
                                "label": "Jakarta",
                                "value": "1"
                            },
                            {
                                "label": "Bandung",
                                "value": "2"
                            }
                        ],
                        "itemNameOption": [
                            {
                                "label": "Item A",
                                "value": "1"
                            },
                            {
                                "label": "Item B",
                                "value": "2"
                            }
                        ],
                        "modifiedByOption": [
                            {
                                "label": "User A",
                                "value": "1"
                            },
                            {
                                "label": "User B",
                                "value": "2"
                            }
                        ],
                        "statusOption": [
                            {
                                "label": "Active",
                                "value": true
                            },
                            {
                                "label": "Inactive",
                                "value": false
                            }
                        ]
                    }
                }
            """.trimIndent()
            )
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        // Panggil API dengan query kosong
        val response = api.getFilterListOption(token)

        // Verifikasi hasilnya
        assertThat(response.isSuccessful).isTrue()
        assertThat(response.body()).isNotNull()
        assertThat(response.body()?.data?.supplierOption).isNotEmpty()
        assertThat(response.body()?.data?.supplierOption?.size).isEqualTo(2)
        assertThat(response.body()?.data?.supplierOption?.first()?.label).isEqualTo("PT. A")
    }

    @Test
    fun `getChangelogFilterOption should return success response`() = runBlocking {
        // Simulasikan respons JSON dari API
        val mockResponse = MockResponse()
            .setBody(
                """
                {
                    "data": {
                        "actionOption": [
                            {
                                "label": "UPDATE",
                                "value": "UPDATE"
                            },
                            {
                                "label": "DELETE",
                                "value": "DELETE"
                            }
                        ],
                        "fieldOption": [
                            {
                                "label": "status",
                                "value": "status"
                            },
                            {
                                "label": "price",
                                "value": "price"
                            }
                        ],
                        "modifiedByOption": [
                            {
                                "label": "User A",
                                "value": "User A"
                            },
                            {
                                "label": "User B",
                                "value": "User B"
                            }
                        ]
                    }
                }
                """.trimIndent()
            )
            .setResponseCode(200)
        mockWebServer.enqueue(mockResponse)

        // Panggil API dengan query kosong
        val response = api.getChangelogOption(token)

        // Verifikasi hasilnya
        assertThat(response.isSuccessful).isTrue()
        assertThat(response.body()).isNotNull()
        assertThat(response.body()?.data?.actionOption).isNotEmpty()
        assertThat(response.body()?.data?.actionOption?.size).isEqualTo(2)
        assertThat(response.body()?.data?.actionOption?.first()?.label).isEqualTo("UPDATE")
    }
}