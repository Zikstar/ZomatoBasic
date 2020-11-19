package com.isaac.zomatobasic.data

import com.isaac.zomatobasic.data.networkHelpers.safeApiCall
import kotlinx.coroutines.Dispatchers

class ZomatoRepository {
    private var zomatoApiClient = RetrofitClient.zomatoApi


    suspend fun getLocation() = safeApiCall(Dispatchers.IO){
        zomatoApiClient.getLocation("New York")
    }
    suspend fun getLocationDetails(entityId : Int, entityType: String) = safeApiCall(Dispatchers.IO){
        zomatoApiClient.getLocationDetails(entityId, entityType)
    }

    suspend fun searchForRestaurant(searchString: String) = safeApiCall(Dispatchers.IO){
        zomatoApiClient.search(280, "city", searchString)
    }

}