import com.google.common.truth.Truth.assertThat
import com.project.libs.data.source.network.model.request.GetSupplierListParamsRequest
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetSupplierListParamsRequestTest {

    @Test
    fun `verify default values`() = runTest {
        val request = GetSupplierListParamsRequest()
        assertThat(request.search).isNull()
        assertThat(request.supplier).isNull()
        assertThat(request.city).isNull()
        assertThat(request.itemName).isNull()
        assertThat(request.modifiedBy).isNull()
        assertThat(request.page).isNull()
        assertThat(request.limit).isNull()
        assertThat(request.sortOrder).isNull()
        assertThat(request.date).isNull()
        assertThat(request.status).isNull()
        assertThat(request.sortBy).isNull()
    }

    @Test
    fun `verify object initialization`() = runTest {
        val request = GetSupplierListParamsRequest(
            search = "searchTerm",
            supplier = "supplierName",
            city = "cityName",
            itemName = "itemName",
            modifiedBy = "modifier",
            page = 1,
            limit = 10,
            sortOrder = true,
            date = "2023-01-01",
            status = "active",
            sortBy = "date"
        )
        assertThat(request.search).isEqualTo("searchTerm")
        assertThat(request.supplier).isEqualTo("supplierName")
        assertThat(request.city).isEqualTo("cityName")
        assertThat(request.itemName).isEqualTo("itemName")
        assertThat(request.modifiedBy).isEqualTo("modifier")
        assertThat(request.page).isEqualTo(1)
        assertThat(request.limit).isEqualTo(10)
        assertThat(request.sortOrder).isTrue()
        assertThat(request.date).isEqualTo("2023-01-01")
        assertThat(request.status).isEqualTo("active")
        assertThat(request.sortBy).isEqualTo("date")
    }

    @Test
    fun `verify toQueryMap method`() = runTest {
        val request = GetSupplierListParamsRequest(
            search = "searchTerm",
            supplier = "supplierName",
            city = "cityName",
            itemName = "itemName",
            modifiedBy = "modifier",
            page = 1,
            limit = 10,
            sortOrder = true,
            date = "2023-01-01",
            status = "active",
            sortBy = "date"
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["search"]).isEqualTo("searchTerm")
        assertThat(queryMap["supplier"]).isEqualTo("supplierName")
        assertThat(queryMap["city"]).isEqualTo("cityName")
        assertThat(queryMap["itemName"]).isEqualTo("itemName")
        assertThat(queryMap["modifiedBy"]).isEqualTo("modifier")
        assertThat(queryMap["page"]).isEqualTo("1")
        assertThat(queryMap["limit"]).isEqualTo("10")
        assertThat(queryMap["sortOrder"]).isEqualTo("true")
        assertThat(queryMap["date"]).isEqualTo("2023-01-01")
        assertThat(queryMap["status"]).isEqualTo("active")
        assertThat(queryMap["sortBy"]).isEqualTo("date")
    }

    @Test
    fun `verify toQueryMap with null values`() = runTest {
        val request = GetSupplierListParamsRequest(
            search = null,
            supplier = null,
            city = null,
            itemName = null,
            modifiedBy = null,
            page = null,
            limit = null,
            sortOrder = null,
            date = null,
            status = null,
            sortBy = null
        )
        val queryMap = request.toQueryMap()
        assertThat(queryMap["search"]).isNull()
        assertThat(queryMap["supplier"]).isNull()
        assertThat(queryMap["city"]).isNull()
        assertThat(queryMap["itemName"]).isNull()
        assertThat(queryMap["modifiedBy"]).isNull()
        assertThat(queryMap["page"]).isNull()
        assertThat(queryMap["limit"]).isNull()
        assertThat(queryMap["sortOrder"]).isNull()
        assertThat(queryMap["date"]).isNull()
        assertThat(queryMap["status"]).isNull()
        assertThat(queryMap["sortBy"]).isNull()
    }
}