package dev.xxxxx.api.impl.data

import org.junit.Assert
import org.junit.Test

class StationResponseTest {
    private val testResponse = StationResponse("ABCD", listOf(), "EFGH", "OK")

    @Test
    fun `test ApiCity data class for coverage`() {

        Assert.assertEquals("ABCD", testResponse.date)
        Assert.assertEquals(listOf<ApiStation>(), testResponse.stationList)
        Assert.assertEquals("EFGH", testResponse.note)
        Assert.assertEquals("OK", testResponse.result)
    }
}