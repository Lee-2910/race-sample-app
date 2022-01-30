package com.project.race.lee.sample.feature

import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.project.race.lee.sample.databinding.ActivitySearchBusinessBinding
import com.project.race.lee.sample.feature.adapter.BusinessAdapter
import com.project.race.lee.sample.feature.model.BusinessViewState
import dagger.hilt.android.AndroidEntryPoint
import android.widget.RadioButton
import com.project.race.lee.sample.utils.*
import java.util.*


@AndroidEntryPoint
class BusinessActivity : AppCompatActivity() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var latitude: Double? = null
    private var longitude: Double? = null
    private val viewModel by viewModels<BusinessViewModel>()
    private var searchType: Int = SearchType.NAME
    private var sortType: Int = SortType.DISTANCE
    private lateinit var viewBinding: ActivitySearchBusinessBinding

    private val seatAvailableAdapter: BusinessAdapter by lazy {
        BusinessAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        viewBinding = ActivitySearchBusinessBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        obtieneLocalizacion()
        initViews()
        setupObservers()

        viewBinding.searchBar.setIconifiedByDefault(false)
        viewBinding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?) = true
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query == null) return true
                viewModel.getBusiness(
                    searchType,
                    sortType,
                    query.lowercase(Locale.getDefault()),
                    latitude,
                    longitude
                )
                return true
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun obtieneLocalizacion() {
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                latitude = location?.latitude
                longitude = location?.longitude
            }
    }

    private fun setupObservers() {
        viewModel.detailViewState.observe(this, {
            when (it) {
                is BusinessViewState.Error -> {
                    viewBinding.progressBar.visibility = View.INVISIBLE
                    Toast.makeText(this, it.throwable?.message, Toast.LENGTH_SHORT)
                        .show()
                }
                is BusinessViewState.GetBusinessSucceed -> {
                    viewBinding.progressBar.visibility = View.INVISIBLE
                    seatAvailableAdapter.submitList(it.businessAvailable)
                }
                BusinessViewState.Loading -> {
                    viewBinding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun initViews() {
        with(viewBinding.rvBusinessAvailable) {
            adapter = seatAvailableAdapter
            isNestedScrollingEnabled = false
        }
        viewBinding.progressBar.visibility = View.INVISIBLE
        viewBinding.radioGroupSearchType.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById(checkedId) as RadioButton
            val isChecked = checkedRadioButton.isChecked
            if (isChecked) {
                searchType = when (checkedRadioButton.text) {
                    NAME -> {
                        SearchType.NAME
                    }
                    ADDRESS -> {
                        SearchType.ADDRESS
                    }
                    else -> {
                        SearchType.CATEGORIES
                    }
                }
            }
        }
        viewBinding.radioGroupSortType.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById(checkedId) as RadioButton
            val isChecked = checkedRadioButton.isChecked
            if (isChecked) {
                sortType = when (checkedRadioButton.text) {
                    DISTANCE -> {
                        SortType.DISTANCE
                    }
                    else -> {
                        SortType.RATINGS
                    }
                }
            }
        }
    }
}