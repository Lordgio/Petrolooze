package dev.xxxxx.api.impl

import dev.xxxxx.api.fake.mocks.AutonomyMocks
import dev.xxxxx.api.fake.mocks.CityMocks
import dev.xxxxx.api.fake.mocks.ProductMocks
import dev.xxxxx.api.fake.mocks.ProvinceMocks
import dev.xxxxx.api.impl.data.StationResponse
import dev.xxxxx.api.impl.retrofit.CurrentDataClient
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
class CurrentDataApiIntegrationTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val client: CurrentDataClient = mockk()
    private lateinit var api: CurrentDataApiImpl
    private val mockedResponse = StationResponse("", listOf(), "", "")

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        api = CurrentDataApiImpl(client)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `get Stations passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStations() } returns mockedResponse
        api.getAllStations()
        coVerify(exactly = 1) { client.getStations() }
    }

    @Test
    fun `get Stations by Autonomy passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByAutonomy(any()) } returns mockedResponse
        api.getStationsByAutonomy(AutonomyMocks.autonomy1)
        coVerify(exactly = 1) { client.getStationsByAutonomy(any()) }
    }

    @Test
    fun `get Stations by Autonomy and Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByAutonomyAndProduct(any(), any()) } returns mockedResponse
        api.getStationsByAutonomyAndProduct(AutonomyMocks.autonomy1, ProductMocks.product1)
        coVerify(exactly = 1) { client.getStationsByAutonomyAndProduct(any(), any()) }
    }

    @Test
    fun `get Stations by City passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByCity(any()) } returns mockedResponse
        api.getStationsByCity(CityMocks.city1)
        coVerify(exactly = 1) { client.getStationsByCity(any()) }
    }

    @Test
    fun `get Stations by City and Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByCityAndProduct(any(), any()) } returns mockedResponse
        api.getStationsByCityAndProduct(CityMocks.city1, ProductMocks.product1)
        coVerify(exactly = 1) { client.getStationsByCityAndProduct(any(), any()) }
    }

    @Test
    fun `get Stations by Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByProduct(any()) } returns mockedResponse
        api.getStationsByProduct(ProductMocks.product1)
        coVerify(exactly = 1) { client.getStationsByProduct(any()) }
    }

    @Test
    fun `get Stations by Province passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByProvince(any()) } returns mockedResponse
        api.getStationsByProvince(ProvinceMocks.province1)
        coVerify(exactly = 1) { client.getStationsByProvince(any()) }
    }

    @Test
    fun `get Stations by Province and Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByProvinceAndProduct(any(), any()) } returns mockedResponse
        api.getStationsByProvinceAndProduct(ProvinceMocks.province1, ProductMocks.product1)
        coVerify(exactly = 1) { client.getStationsByProvinceAndProduct(any(), any()) }
    }
}
