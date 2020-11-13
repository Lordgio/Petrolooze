package dev.xxxxx.api.impl

import dev.xxxxx.api.data.*
import dev.xxxxx.api.fake.mocks.AutonomyMocks
import dev.xxxxx.api.fake.mocks.CityMocks
import dev.xxxxx.api.fake.mocks.ProductMocks
import dev.xxxxx.api.fake.mocks.ProvinceMocks
import dev.xxxxx.api.impl.data.StationResponse
import dev.xxxxx.api.impl.retrofit.CurrentDataClient
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
class CurrentDataApiImplTest {

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
    fun `get all Stations returns correct responses`() = runBlockingTest {
        coEvery { client.getStations() } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getAllStations())
    }

    @Test
    fun `get all Stations throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStations() } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getAllStations() }
    }

    @Test
    fun `get Stations by Autonomy returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByAutonomy(any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByAutonomy(AutonomyMocks.autonomy1))
    }

    @Test
    fun `get Stations by Autonomy throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByAutonomy(any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByAutonomy(AutonomyMocks.autonomy1) }
    }

    @Test
    fun `get Stations by Autonomy and Product returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByAutonomyAndProduct(any(), any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByAutonomyAndProduct(AutonomyMocks.autonomy1, ProductMocks.product1))
    }

    @Test
    fun `get Stations by Autonomy and Product throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByAutonomyAndProduct(any(), any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByAutonomyAndProduct(AutonomyMocks.autonomy1, ProductMocks.product1) }
    }

    @Test
    fun `get Stations by City returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByCity(any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByCity(CityMocks.city1))
    }

    @Test
    fun `get Stations by City throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByCity(any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByCity(CityMocks.city1) }
    }

    @Test
    fun `get Stations by City and Product returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByCityAndProduct(any(), any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByCityAndProduct(CityMocks.city1, ProductMocks.product1))
    }

    @Test
    fun `get Stations by City and Product throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByCityAndProduct(any(), any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByCityAndProduct(CityMocks.city1, ProductMocks.product1) }
    }

    @Test
    fun `get Stations by Product returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByProduct(any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByProduct(ProductMocks.product1))
    }

    @Test
    fun `get Stations by Product throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByProduct(any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByProduct(ProductMocks.product1) }
    }

    @Test
    fun `get Stations by Province returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByProvince(any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByProvince(ProvinceMocks.province1))
    }

    @Test
    fun `get Stations by Province throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByProvince(any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByProvince(ProvinceMocks.province1) }
    }

    @Test
    fun `get Stations by Province and Product returns correct responses`() = runBlockingTest {
        coEvery { client.getStationsByProvinceAndProduct(any(), any()) } returns mockedResponse
        Assert.assertEquals(listOf<Station>(), api.getStationsByProvinceAndProduct(ProvinceMocks.province1, ProductMocks.product1))
    }

    @Test
    fun `get Stations by Province and Product throws exception on error responses`() = runBlockingTest {
        coEvery { client.getStationsByProvinceAndProduct(any(), any()) } throws Exception("Error")
        assertThrows<Exception>("Error") { api.getStationsByProvinceAndProduct(ProvinceMocks.province1, ProductMocks.product1) }
    }
}