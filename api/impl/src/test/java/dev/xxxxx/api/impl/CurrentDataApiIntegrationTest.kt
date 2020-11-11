package dev.xxxxx.api.impl

import dev.xxxxx.api.data.Autonomy
import dev.xxxxx.api.data.City
import dev.xxxxx.api.data.Product
import dev.xxxxx.api.data.Province
import dev.xxxxx.api.impl.data.StationResponse
import dev.xxxxx.api.impl.retrofit.CurrentDataClient
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class CurrentDataApiIntegrationTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val client: CurrentDataClient = mockk()
    private lateinit var api: CurrentDataApiImpl

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
        coEvery { client.getStations() } returns StationResponse("", listOf(), "", "")
        api.getAllStations()
        coVerify(exactly = 1) { client.getStations() }
    }

    @Test
    fun `get Stations by Autonomy passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByAutonomy("") } returns StationResponse("", listOf(), "", "")
        api.getStationsByAutonomy(Autonomy("", ""))
        coVerify(exactly = 1) { client.getStationsByAutonomy("") }
    }

    @Test
    fun `get Stations by Autonomy and Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByAutonomyAndProduct("", "") } returns StationResponse("", listOf(), "", "")
        api.getStationsByAutonomyAndProduct(Autonomy("", ""), Product("", "", ""))
        coVerify(exactly = 1) { client.getStationsByAutonomyAndProduct("", "") }
    }

    @Test
    fun `get Stations by City passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByCity("") } returns StationResponse("", listOf(), "", "")
        api.getStationsByCity(City("", "", "", "", "", ""))
        coVerify(exactly = 1) { client.getStationsByCity("") }
    }

    @Test
    fun `get Stations by City and Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByCityAndProduct("", "") } returns StationResponse("", listOf(), "", "")
        api.getStationsByCityAndProduct(City("", "", "", "", "", ""), Product("", "", ""))
        coVerify(exactly = 1) { client.getStationsByCityAndProduct("", "") }
    }

    @Test
    fun `get Stations by Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByProduct("") } returns StationResponse("", listOf(), "", "")
        api.getStationsByProduct(Product("", "", ""))
        coVerify(exactly = 1) { client.getStationsByProduct("") }
    }

    @Test
    fun `get Stations by Province passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByProvince("") } returns StationResponse("", listOf(), "", "")
        api.getStationsByProvince(Province("", "", "", ""))
        coVerify(exactly = 1) { client.getStationsByProvince("") }
    }

    @Test
    fun `get Stations by Province and Product passes the call to Retrofit correctly`() = runBlockingTest {
        coEvery { client.getStationsByProvinceAndProduct("", "") } returns StationResponse("", listOf(), "", "")
        api.getStationsByProvinceAndProduct(Province("", "", "", ""), Product("", "", ""))
        coVerify(exactly = 1) { client.getStationsByProvinceAndProduct("", "") }
    }
}
