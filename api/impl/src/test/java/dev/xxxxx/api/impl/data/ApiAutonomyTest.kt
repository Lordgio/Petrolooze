package dev.xxxxx.api.impl.data

import org.junit.Assert
import org.junit.Test

class ApiAutonomyTest {

    private val testAutonomy = ApiAutonomy("ABCD", "01")

    @Test
    fun `test ApiAutonomy data class for coverage`() {

        Assert.assertEquals("ABCD", testAutonomy.ccaa)
        Assert.assertEquals("01", testAutonomy.idCCAA)
    }

    @Test
    fun `test ApiAutonomy transform extension function`() {

        val autonomy = testAutonomy.toAutonomy()

        Assert.assertEquals(testAutonomy.ccaa, autonomy.name)
        Assert.assertEquals(testAutonomy.idCCAA, autonomy.id)
    }
}