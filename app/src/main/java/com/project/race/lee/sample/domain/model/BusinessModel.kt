package com.project.race.lee.sample.domain.model

import com.project.race.lee.sample.data.network.model.response.Business
import com.project.race.lee.sample.data.network.model.response.BusinessSearchResponse

data class BusinessModel(
    val name: String,
    val imageUrl: String,
    val categories: String,
    val hourOpen: String,
    val hourClose: String,
    val isOpen: Boolean?,
    val address: String,
    val rating: String,
    val transactions: String,
    val phone: String
) {

    companion object {

        private fun convertToBusinessModel(response: Business): BusinessModel {
            return BusinessModel(
                name = response.name,
                imageUrl = response.imageUrl,
                categories = categoriesConvertToString(response.categories).orEmpty(),
                hourOpen = getHourOpen(response.hours).orEmpty(),
                hourClose = getHourClose(response.hours).orEmpty(),
                isOpen = isOpen(response.hours),
                address = response.address?.displayAddress.toString(),
                rating = response.rating.orEmpty(),
                transactions = getTransactions(response.transactions).orEmpty(),
                phone = response.displayPhone.orEmpty()
            )
        }

        fun convertToBusinessListModel(listResponse: BusinessSearchResponse?): List<BusinessModel> {
            return listResponse?.businesses?.map { it -> convertToBusinessModel(it) } ?: arrayListOf()
        }

        private fun categoriesConvertToString(categories: List<Business.Categories>?): String? {
            return categories?.map { it.title }?.toString()
        }

        private fun getTransactions(transactions: List<String>?): String? {
            return if (transactions.isNullOrEmpty()) null else transactions.toString()
        }

        private fun getHourOpen(hours: List<Business.Hours>?): String? {
            hours?.forEach {
                it.open?.forEach { open ->
                    return open.start.orEmpty()
                }
            }
            return null
        }

        private fun getHourClose(hours: List<Business.Hours>?): String? {
            hours?.forEach {
                it.open?.forEach { open ->
                    return open.end.orEmpty()
                }
            }
            return null
        }

        private fun isOpen(hours: List<Business.Hours>?): Boolean? {
            hours?.forEach {
                return it.isOpenNow
            }
            return null
        }

    }
}

data class BusinessListModel(
    val business: List<BusinessModel>
)