package com.project.race.lee.sample.feature.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.race.lee.sample.domain.model.BusinessModel

class BusinessAdapter : ListAdapter<BusinessModel, RecyclerView.ViewHolder>(BusinessDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BusinessItemVH.onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItem(position)) {
            is BusinessModel -> {
                (holder as BusinessItemVH).onBind(model = getItem(position) as BusinessModel)
            }
        }
    }
}

class BusinessDiffCallback : DiffUtil.ItemCallback<BusinessModel>() {

    override fun areItemsTheSame(
        oldItem: BusinessModel,
        newItem: BusinessModel
    ): Boolean {
        return oldItem.name == newItem.name
                && oldItem.imageUrl == newItem.imageUrl
                && oldItem.address == newItem.address
    }

    override fun areContentsTheSame(
        oldItem: BusinessModel,
        newItem: BusinessModel
    ): Boolean {
        return oldItem == newItem
    }
}
