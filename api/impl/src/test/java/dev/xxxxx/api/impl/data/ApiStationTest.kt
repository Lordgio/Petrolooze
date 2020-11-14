package dev.xxxxx.api.impl.data

import org.junit.Assert
import org.junit.Test

class ApiStationTest {
    private val testStation = ApiStation("0.0", "00000", "ABCD", "EFGH",
        "01", "02", "03", "04", "1", "IJKL", "2",
        "05", "3.0", "4.0", "5.0", "6.0", "7.0",
        "8.0", "9.0", "10.0", "11.0", "12.0",
        "13.0", "14.0", "15.0", "16.0",
        "MNOP", "06", "QRST", "07", "17.0")

    @Test
    fun `test ApiCity data class for coverage`() {

        Assert.assertEquals("0.0", testStation.bioethanolPercent)
        Assert.assertEquals("00000", testStation.postalCode)
        Assert.assertEquals("ABCD", testStation.address)
        Assert.assertEquals("EFGH", testStation.timetable)
        Assert.assertEquals("01", testStation.autonomyId)
        Assert.assertEquals("02", testStation.id)
        Assert.assertEquals("03", testStation.cityId)
        Assert.assertEquals("04", testStation.provinceId)
        Assert.assertEquals("1", testStation.latitude)
        Assert.assertEquals("IJKL", testStation.cityName)
        Assert.assertEquals("2", testStation.longitude)
        Assert.assertEquals("05", testStation.margin)
        Assert.assertEquals("3.0", testStation.biodieselPrice)
        Assert.assertEquals("4.0", testStation.bioethanolPrice)
        Assert.assertEquals("5.0", testStation.gncPrice)
        Assert.assertEquals("6.0", testStation.gnlPrice)
        Assert.assertEquals("7.0", testStation.glpPrice)
        Assert.assertEquals("8.0", testStation.aGasPrice)
        Assert.assertEquals("9.0", testStation.bGasPrice)
        Assert.assertEquals("10.0", testStation.premiumGasPrice)
        Assert.assertEquals("11.0", testStation.gas95E10Price)
        Assert.assertEquals("12.0", testStation.gas95E5Price)
        Assert.assertEquals("13.0", testStation.premiumGas95E5Price)
        Assert.assertEquals("14.0", testStation.gas98E10Price)
        Assert.assertEquals("15.0", testStation.gas98E5Price)
        Assert.assertEquals("16.0", testStation.hydrogenPrice)
        Assert.assertEquals("MNOP", testStation.provinceName)
        Assert.assertEquals("06", testStation.remision)
        Assert.assertEquals("QRST", testStation.label)
        Assert.assertEquals("07", testStation.saleType)
        Assert.assertEquals("17.0", testStation.methylicEsterPercent)
    }

    @Test
    fun `test ApiCity transform extension function`() {

        val station = testStation.toStation()

        Assert.assertEquals(testStation.bioethanolPercent.toDouble(), station.bioethanolPercent, 0.0)
        Assert.assertEquals(testStation.postalCode, station.postalCode)
        Assert.assertEquals(testStation.address, station.address)
        Assert.assertEquals(testStation.timetable, station.timetable)
        Assert.assertEquals(testStation.autonomyId, station.autonomyId)
        Assert.assertEquals(testStation.id, station.id)
        Assert.assertEquals(testStation.cityId, station.cityId)
        Assert.assertEquals(testStation.provinceId, station.provinceId)
        Assert.assertEquals(testStation.latitude.toLong(), station.latitude)
        Assert.assertEquals(testStation.cityName, station.cityName)
        Assert.assertEquals(testStation.longitude.toLong(), station.longitude)
        Assert.assertEquals(testStation.margin, station.margin)
        Assert.assertEquals(testStation.biodieselPrice.toDouble(), station.biodieselPrice, 0.0)
        Assert.assertEquals(testStation.bioethanolPrice.toDouble(), station.bioethanolPrice, 0.0)
        Assert.assertEquals(testStation.gncPrice.toDouble(), station.gncPrice, 0.0)
        Assert.assertEquals(testStation.gnlPrice.toDouble(), station.gnlPrice, 0.0)
        Assert.assertEquals(testStation.glpPrice.toDouble(), station.glpPrice, 0.0)
        Assert.assertEquals(testStation.aGasPrice.toDouble(), station.aGasPrice, 0.0)
        Assert.assertEquals(testStation.bGasPrice.toDouble(), station.bGasPrice, 0.0)
        Assert.assertEquals(testStation.premiumGasPrice.toDouble(), station.premiumGasPrice, 0.0)
        Assert.assertEquals(testStation.gas95E10Price.toDouble(), station.gas95E10Price, 0.0)
        Assert.assertEquals(testStation.gas95E5Price.toDouble(), station.gas95E5Price, 0.0)
        Assert.assertEquals(testStation.premiumGas95E5Price.toDouble(), station.premiumGas95E5Price, 0.0)
        Assert.assertEquals(testStation.gas98E10Price.toDouble(), station.gas98E10Price, 0.0)
        Assert.assertEquals(testStation.gas98E5Price.toDouble(), station.gas98E5Price, 0.0)
        Assert.assertEquals(testStation.hydrogenPrice.toDouble(), station.hydrogenPrice, 0.0)
        Assert.assertEquals(testStation.provinceName, station.provinceName)
        Assert.assertEquals(testStation.remision, station.remision)
        Assert.assertEquals(testStation.label, station.label)
        Assert.assertEquals(testStation.saleType, station.saleType)
        Assert.assertEquals(testStation.methylicEsterPercent.toDouble(), station.methylicEsterPercent, 0.0)
    }
}