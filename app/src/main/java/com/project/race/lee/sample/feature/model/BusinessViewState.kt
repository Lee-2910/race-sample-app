package com.project.race.lee.sample.feature.model

import com.project.race.lee.sample.domain.model.BusinessModel


sealed class BusinessViewState {
    object Loading : BusinessViewState()

    class GetBusinessSucceed(val businessAvailable: List<BusinessModel>) :
        BusinessViewState()

    class Error(val throwable: Throwable?) : BusinessViewState()
}