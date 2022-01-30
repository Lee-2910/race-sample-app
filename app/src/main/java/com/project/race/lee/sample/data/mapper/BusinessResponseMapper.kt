package com.project.race.lee.sample.data.mapper


import com.project.race.lee.sample.data.network.model.response.BusinessSearchResponse
import com.project.race.lee.sample.domain.model.BusinessListModel
import com.project.race.lee.sample.domain.model.BusinessModel
import javax.inject.Inject

class BusinessResponseMapper @Inject constructor() :
    Mapper<BusinessSearchResponse, BusinessListModel> {

    override fun map(input: BusinessSearchResponse): BusinessListModel {
        return BusinessListModel(business = BusinessModel.convertToBusinessListModel(input))
    }
}
