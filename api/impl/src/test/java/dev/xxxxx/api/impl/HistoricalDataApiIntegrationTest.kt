package dev.xxxxx.api.impl

import dev.xxxxx.api.impl.retrofit.HistoricalDataClient
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

@ExperimentalCoroutinesApi
class HistoricalDataApiIntegrationTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private val client: HistoricalDataClient = mockk()
    private lateinit var api: HistoricalDataApiImpl

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        api = HistoricalDataApiImpl(client)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
