package dev.xxxxx.api.impl.data

import org.junit.Assert
import org.junit.Test

class ApiProvinceTest {
    private val testProvince = ApiProvince("ABCD", "01", "02", "EFGH")

    @Test
    fun `test ApiCity data class for coverage`() {

        Assert.assertEquals("ABCD", testProvince.ccaa)
        Assert.assertEquals("01", testProvince.idCCAA)
        Assert.assertEquals("02", testProvince.idPovincia)
        Assert.assertEquals("EFGH", testProvince.provincia)
    }

    @Test
    fun `test ApiCity transform extension function`() {

        val province = testProvince.toProvince()

        Assert.assertEquals(testProvince.ccaa, province.autonomyName)
        Assert.assertEquals(testProvince.idCCAA, province.autonomyId)
        Assert.assertEquals(testProvince.idPovincia, province.provinceId)
        Assert.assertEquals(testProvince.provincia, province.provinceName)
    }
}