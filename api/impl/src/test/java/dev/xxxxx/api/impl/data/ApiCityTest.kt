package dev.xxxxx.api.impl.data

import org.junit.Assert
import org.junit.Test

class ApiCityTest {

    private val testCity = ApiCity("ABCD", "01", "02", "03", "EFGH", "IJKL")

    @Test
    fun `test ApiCity data class for coverage`() {

        Assert.assertEquals("ABCD", testCity.ccaa)
        Assert.assertEquals("01", testCity.idCCAA)
        Assert.assertEquals("02", testCity.idMunicipio)
        Assert.assertEquals("03", testCity.idProvincia)
        Assert.assertEquals("EFGH", testCity.municipio)
        Assert.assertEquals("IJKL", testCity.provincia)
    }

    @Test
    fun `test ApiCity transform extension function`() {

        val city = testCity.toCity()

        Assert.assertEquals(testCity.ccaa, city.autonomyName)
        Assert.assertEquals(testCity.idCCAA, city.autonomyId)
        Assert.assertEquals(testCity.idMunicipio, city.id)
        Assert.assertEquals(testCity.idProvincia, city.provinceId)
        Assert.assertEquals(testCity.municipio, city.name)
        Assert.assertEquals(testCity.provincia, city.provinceName)
    }
}