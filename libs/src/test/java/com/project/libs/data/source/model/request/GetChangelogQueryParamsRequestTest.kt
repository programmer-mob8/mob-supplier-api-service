package com.project.libs.data.source.model.request

import com.google.common.truth.Truth.assertThat
import com.project.libs.data.source.network.model.request.GetChangelogQueryParamsRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetChangelogQueryParamsRequestTest {

    @Test
    fun `verify default values`() = runTest {
        val request = GetChangelogQueryParamsRequest()
        assertThat(request.search).isEqualTo(null)
        assertThat(request.action).isEqualTo(null)
        assertThat(request.field).isEqualTo(null)
        assertThat(request.modifiedBy).isEqualTo(null)
        assertThat(request.page).isEqualTo(null)
        assertThat(request.limit).isEqualTo(null)
        assertThat(request.date).isEqualTo(null)
        assertThat(request.sortOrder).isEqualTo(null)
        assertThat(request.sortBy).isEqualTo(null)
    }

    @Test
    fun `verify object initialization`() = runTest {
        val request = GetChangelogQueryParamsRequest(
            search = "testSearch",
            action = "testAction",
            field = "testField",
            modifiedBy = "testModifiedBy",
            page = 1,
            limit = 10,
            date = "2023-10-01",
            sortOrder = true,
            sortBy = "testSortBy"
        )
        assertThat(request.search).isEqualTo("testSearch")
        assertThat(request.action).isEqualTo("testAction")
        assertThat(request.field).isEqualTo("testField")
        assertThat(request.modifiedBy).isEqualTo("testModifiedBy")
        assertThat(request.page).isEqualTo(1)
        assertThat(request.limit).isEqualTo(10)
        assertThat(request.date).isEqualTo("2023-10-01")
        assertThat(request.sortOrder).isEqualTo(true)
        assertThat(request.sortBy).isEqualTo("testSortBy")
    }

    @Test
    fun `verify toQueryMap method`() = runTest {
        val request = GetChangelogQueryParamsRequest(
            search = "testSearch",
            action = "testAction",
            field = "testField",
            modifiedBy = "testModifiedBy",
            page = 1,
            limit = 10,
            date = "2023-10-01",
            sortOrder = true,
            sortBy = "testSortBy"
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["search"]).isEqualTo("testSearch")
        assertThat(queryMap["action"]).isEqualTo("testAction")
        assertThat(queryMap["field"]).isEqualTo("testField")
        assertThat(queryMap["modifiedBy"]).isEqualTo("testModifiedBy")
        assertThat(queryMap["page"]).isEqualTo("1")
        assertThat(queryMap["limit"]).isEqualTo("10")
        assertThat(queryMap["date"]).isEqualTo("2023-10-01")
        assertThat(queryMap["sortOrder"]).isEqualTo("true")
        assertThat(queryMap["sortBy"]).isEqualTo("testSortBy")
    }

    @Test
    fun `verify toQueryMap with null values`() = runTest {
        val request = GetChangelogQueryParamsRequest(
            search = null,
            action = null,
            field = null,
            modifiedBy = null,
            page = null,
            limit = null,
            date = null,
            sortOrder = null,
            sortBy = null
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["search"]).isEqualTo(null)
        assertThat(queryMap["action"]).isEqualTo(null)
        assertThat(queryMap["field"]).isEqualTo(null)
        assertThat(queryMap["modifiedBy"]).isEqualTo(null)
        assertThat(queryMap["page"]).isEqualTo("null")
        assertThat(queryMap["limit"]).isEqualTo("null")
        assertThat(queryMap["date"]).isEqualTo("null")
        assertThat(queryMap["sortOrder"]).isEqualTo("null")
        assertThat(queryMap["sortBy"]).isEqualTo(null)
    }
}