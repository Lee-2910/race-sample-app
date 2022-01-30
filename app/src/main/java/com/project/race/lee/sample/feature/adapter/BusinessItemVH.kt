package com.project.race.lee.sample.feature.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.race.lee.sample.R
import com.project.race.lee.sample.databinding.LayoutBusinessItemBinding
import com.project.race.lee.sample.domain.model.BusinessModel
import com.project.race.lee.sample.utils.hourDisplayFormat

class BusinessItemVH constructor(
    private val binding: LayoutBusinessItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(model: BusinessModel) {
        binding.tvName.text = model.name
        if (model.categories.isNotEmpty()) {
            binding.tvCategories.visibility = View.VISIBLE
            binding.tvCategories.text = model.categories
        }
        if (model.hourOpen.isNotEmpty() || model.hourClose.isNotEmpty()) {
            binding.tvHour.visibility = View.VISIBLE
            binding.tvHour.text = hourDisplayFormat(model.hourOpen, model.hourClose)
        }
        if (model.address.isNotEmpty()) {
            binding.tvAddress.visibility = View.VISIBLE
            binding.tvAddress.text = model.address
        }
        if (model.rating.isNotEmpty()) {
            binding.tvRatings.visibility = View.VISIBLE
            binding.tvRatings.text = model.rating
        }
        if (model.transactions.isNotEmpty()) {
            binding.tvDeals.visibility = View.VISIBLE
            binding.tvDeals.text = model.transactions
        }
        if (model.phone.isNotEmpty()) {
            binding.tvPhone.visibility = View.VISIBLE
            binding.tvPhone.text = model.phone
        }
        Glide
            .with(binding.image.context)
            .load(model.imageUrl)
            .circleCrop()
            .placeholder(R.drawable.bg_circle_placeholder)
            .into(binding.image)
    }

    companion object {

        fun onCreateViewHolder(
            parent: ViewGroup,
        ): RecyclerView.ViewHolder {
            val binding = LayoutBusinessItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            return BusinessItemVH(binding = binding)
        }
    }
}