import com.google.common.truth.Truth.assertThat
import com.project.libs.data.source.network.model.request.GetFilterListOptionRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetFilterListOptionRequestTest {

    @Test
    fun `verify default values`() = runTest {
        val request = GetFilterListOptionRequest()
        assertThat(request.itemNameOption).isEqualTo("true")
        assertThat(request.modifiedByOption).isEqualTo("true")
        assertThat(request.supplierOption).isEqualTo("true")
        assertThat(request.cityOption).isEqualTo("true")
        assertThat(request.statusOption).isEqualTo("true")
    }

    @Test
    fun `verify object initialization`() = runTest {
        val request = GetFilterListOptionRequest(
            itemNameOption = "false",
            modifiedByOption = "false",
            supplierOption = "false",
            cityOption = "false",
            statusOption = "false"
        )
        assertThat(request.itemNameOption).isEqualTo("false")
        assertThat(request.modifiedByOption).isEqualTo("false")
        assertThat(request.supplierOption).isEqualTo("false")
        assertThat(request.cityOption).isEqualTo("false")
        assertThat(request.statusOption).isEqualTo("false")
    }

    @Test
    fun `verify toQueryMap method`() = runTest {
        val request = GetFilterListOptionRequest(
            itemNameOption = "false",
            modifiedByOption = "false",
            supplierOption = "false",
            cityOption = "false",
            statusOption = "false"
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["itemNameOption"]).isEqualTo("false")
        assertThat(queryMap["modifiedByOption"]).isEqualTo("false")
        assertThat(queryMap["supplierOption"]).isEqualTo("false")
        assertThat(queryMap["cityOption"]).isEqualTo("false")
        assertThat(queryMap["statusOption"]).isEqualTo("false")
    }

    @Test
    fun `verify toQueryMap with null values`() = runTest {
        val request = GetFilterListOptionRequest(
            itemNameOption = null,
            modifiedByOption = null,
            supplierOption = null,
            cityOption = null,
            statusOption = null
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["itemNameOption"]).isEqualTo(null)
        assertThat(queryMap["modifiedByOption"]).isEqualTo(null)
        assertThat(queryMap["supplierOption"]).isEqualTo(null)
        assertThat(queryMap["cityOption"]).isEqualTo(null)
        assertThat(queryMap["statusOption"]).isEqualTo(null)
    }
}