package com.project.libs.data.source.model.request

import com.google.common.truth.Truth.assertThat
import com.project.libs.data.source.network.model.request.GetChangelogFilterOptionRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetChangelogFilterOptionRequestTest {

    @Test
    fun `verify default values`() = runTest {
        val request = GetChangelogFilterOptionRequest()
        assertThat(request.modifiedByOption).isEqualTo("true")
        assertThat(request.actionOption).isEqualTo("true")
        assertThat(request.fieldOption).isEqualTo("true")
    }

    @Test
    fun `verify object initialization`() = runTest {
        val request = GetChangelogFilterOptionRequest(
            modifiedByOption = "false",
            actionOption = "false",
            fieldOption = "false"
        )
        assertThat(request.modifiedByOption).isEqualTo("false")
        assertThat(request.actionOption).isEqualTo("false")
        assertThat(request.fieldOption).isEqualTo("false")
    }

    @Test
    fun `verify toQueryMap method`() = runTest {
        val request = GetChangelogFilterOptionRequest(
            modifiedByOption = "false",
            actionOption = "false",
            fieldOption = "false"
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["modifiedByOption"]).isEqualTo("false")
        assertThat(queryMap["actionOption"]).isEqualTo("false")
        assertThat(queryMap["fieldOption"]).isEqualTo("false")
    }

    @Test
    fun `verify toQueryMap with null values`() = runTest {
        val request = GetChangelogFilterOptionRequest(
            modifiedByOption = null,
            actionOption = null,
            fieldOption = null
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["modifiedByOption"]).isEqualTo("null")
        assertThat(queryMap["actionOption"]).isEqualTo("null")
        assertThat(queryMap["fieldOption"]).isEqualTo("null")
    }
}