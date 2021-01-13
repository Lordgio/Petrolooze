package dev.xxxxx.api.impl.data

import org.junit.Assert
import org.junit.Test

class ApiProductTest {
    private val testProduct = ApiProduct("01", "ABCD", "AB")

    @Test
    fun `test ApiProduct data class for coverage`() {

        Assert.assertEquals("01", testProduct.idProducto)
        Assert.assertEquals("ABCD", testProduct.nombreProducto)
        Assert.assertEquals("AB", testProduct.nombreProductoAbreviatura)
    }

    @Test
    fun `test ApiProduct transform extension function`() {

        val product = testProduct.toProduct()

        Assert.assertEquals(testProduct.nombreProducto, product.name)
        Assert.assertEquals(testProduct.idProducto, product.id)
        Assert.assertEquals(testProduct.nombreProductoAbreviatura, product.abbreviation)
    }
}