package com.project.race.lee.sample.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.project.race.lee.sample.data.mapper.BusinessResponseMapper
import com.project.race.lee.sample.data.network.BusinessNetworkService
import com.project.race.lee.sample.domain.repository.BusinessRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BusinessRepositoryImplTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var businessRepository: BusinessRepository

    @RelaxedMockK
    lateinit var businessNetworkService: BusinessNetworkService

    @RelaxedMockK
    lateinit var businessMapperHolder: BusinessResponseMapper

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        businessRepository = BusinessRepositoryImpl(businessNetworkService, businessMapperHolder)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getBusiness(): Unit = runBlocking {
        // create a test json file and write test logic here
        // can use okhttp3 mockwebserver to create a mock server with json for test
        businessRepository.getBusiness("ab","coffee","NY",0.0,0.0)
    }
}