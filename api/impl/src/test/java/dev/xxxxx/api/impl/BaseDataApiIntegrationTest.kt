package dev.xxxxx.api.impl

import dev.xxxxx.api.impl.retrofit.BaseDataClient
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class BaseDataApiIntegrationTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val client: BaseDataClient = mockk()
    private lateinit var api: BaseDataApiImpl

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        api = BaseDataApiImpl(client)
    }

    @Test
    fun `get Autonomies passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getAutonomies() } returns listOf()
        api.getAutonomies()
        coVerify(exactly = 1) { client.getAutonomies() }
    }

    @Test
    fun `get Cities passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getCities() } returns listOf()
        api.getCities()
        coVerify(exactly = 1) { client.getCities() }
    }

    @Test
    fun `get Products passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getProducts() } returns listOf()
        api.getProducts()
        coVerify(exactly = 1) { client.getProducts() }
    }

    @Test
    fun `get Provinces passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getProvinces() } returns listOf()
        api.getProvinces()
        coVerify(exactly = 1) { client.getProvinces() }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}