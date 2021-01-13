package dev.xxxxx.api.impl

import arrow.core.Either
import dev.xxxxx.api.data.*
import dev.xxxxx.api.impl.retrofit.BaseDataClient
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class BaseDataApiImplTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val client: BaseDataClient = mockk()
    private lateinit var api: BaseDataApiImpl

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        api = BaseDataApiImpl(client)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `get Autonomies returns correct responses`() = runBlockingTest {
        coEvery { client.getAutonomies() } returns listOf()
        Assert.assertEquals(Either.right(listOf<Autonomy>()), api.getAutonomies())
    }

    @Test
    fun `get Autonomies throws exception on error responses`() = runBlockingTest {
        coEvery { client.getAutonomies() } throws Exception("Error")
        val result = api.getAutonomies()
        val internal = result.fold({ it }, { it })
        Assert.assertTrue(result is Either.Left<*>)
        Assert.assertTrue(internal is NetworkError.GenericError)
    }

    @Test
    fun `get Cities returns correct responses`() = runBlockingTest {
        coEvery { client.getCities() } returns listOf()
        Assert.assertEquals(Either.right(listOf<City>()), api.getCities())
    }

    @Test
    fun `get Cities throws exception on error responses`() = runBlockingTest {
        coEvery { client.getCities() } throws Exception("Error")
        val result = api.getCities()
        val internal = result.fold({ it }, { it })
        Assert.assertTrue(result is Either.Left<*>)
        Assert.assertTrue(internal is NetworkError.GenericError)
    }

    @Test
    fun `get Products returns correct responses`() = runBlockingTest {
        coEvery { client.getProducts() } returns listOf()
        Assert.assertEquals(Either.right(listOf<Product>()), api.getProducts())
    }

    @Test
    fun `get Products throws exception on error responses`() = runBlockingTest {
        coEvery { client.getProducts() } throws Exception("Error")
        val result = api.getProducts()
        val internal = result.fold({ it }, { it })
        Assert.assertTrue(result is Either.Left<*>)
        Assert.assertTrue(internal is NetworkError.GenericError)
    }

    @Test
    fun `get Provinces returns correct responses`() = runBlockingTest {
        coEvery { client.getProvinces() } returns listOf()
        Assert.assertEquals(Either.right(listOf<Province>()), api.getProvinces())
    }

    @Test
    fun `get Provinces throws exception on error responses`() = runBlockingTest {
        coEvery { client.getProvinces() } throws Exception("Error")
        val result = api.getProvinces()
        val internal = result.fold({ it }, { it })
        Assert.assertTrue(result is Either.Left<*>)
        Assert.assertTrue(internal is NetworkError.GenericError)
    }
}