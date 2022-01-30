package com.project.race.lee.sample.feature

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.project.race.lee.sample.domain.usecase.BusinessUseCase
import com.project.race.lee.sample.utils.SearchType
import com.project.race.lee.sample.utils.SortType
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BusinessViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BusinessViewModel

    @MockK
    lateinit var businessUseCase: BusinessUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = BusinessViewModel(businessUseCase)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `test getBusiness method`() {
        // create a test json file and write test logic here
        // can use okhttp3 mockwebserver to create a mock server with json for test
        viewModel.getBusiness(SearchType.NAME, SortType.DISTANCE, "ab", 0.0, 0.0)
    }
}