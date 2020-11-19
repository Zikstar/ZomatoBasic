package com.isaac.zomatobasic

import androidx.lifecycle.*
import com.isaac.zomatobasic.data.ZomatoRepository
import com.isaac.zomatobasic.data.models.LocationDetails
import com.isaac.zomatobasic.data.models.helpers.SearchResultResponse
import com.isaac.zomatobasic.data.networkHelpers.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {
    private val repository = ZomatoRepository()
    private var _locDetailsLiveData = MutableLiveData<ResultWrapper<LocationDetails>>()
    val locationDetailsLiveData: LiveData<ResultWrapper<LocationDetails>> = _locDetailsLiveData

    private var _searchResultsLiveData = MutableLiveData<ResultWrapper<SearchResultResponse>>()
    val searchResultsLiveData: LiveData<ResultWrapper<SearchResultResponse>> = _searchResultsLiveData


    val locationData = liveData(Dispatchers.IO) {
        val learnerResponse = repository.getLocation()
        emit(learnerResponse)
    }


    fun getLocationDetails(entityId: Int, entityType: String) = viewModelScope.launch {
        val response = repository.getLocationDetails(entityId, entityType)
        _locDetailsLiveData.value = response
    }

    fun searchForRestaurant(searchString: String) = viewModelScope.launch {
        val response = repository.searchForRestaurant(searchString)
        _searchResultsLiveData.value = response
    }

}