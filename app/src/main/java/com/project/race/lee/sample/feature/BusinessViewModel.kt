package com.project.race.lee.sample.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.race.lee.sample.domain.model.BusinessModel
import com.project.race.lee.sample.domain.usecase.BusinessUseCase
import com.project.race.lee.sample.feature.model.BusinessViewState
import com.project.race.lee.sample.utils.SearchType
import com.project.race.lee.sample.utils.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(
    private val businessUseCase: BusinessUseCase,
) : ViewModel() {
    val detailViewState = MutableLiveData<BusinessViewState>()
    fun getBusiness(
        @SearchType searchType: Int,
        @SortType sortType: Int,
        key: String,
        lat: Double?,
        long: Double?
    ) {
        detailViewState.postValue(BusinessViewState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val result = businessUseCase.getBusiness(searchType, sortType, key, lat, long)
            when {
                result.isFailure -> {
                    detailViewState.postValue(BusinessViewState.Error(throwable = result.exceptionOrNull()))
                }
                result.isSuccess -> {
                    result.getOrNull()?.let {
                        detailViewState.postValue(
                            BusinessViewState.GetBusinessSucceed(
                                businessAvailable = filterBusinessAvailable(it)
                            )
                        )
                    }
                }
            }
        }
    }


    private fun filterBusinessAvailable(input: List<BusinessModel>): List<BusinessModel> {
        return input.filter { it.name.isNotEmpty() }
    }
}