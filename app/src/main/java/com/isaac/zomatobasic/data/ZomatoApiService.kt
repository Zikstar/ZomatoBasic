package com.isaac.zomatobasic.data

import com.isaac.zomatobasic.data.models.LocationDetails
import com.isaac.zomatobasic.data.models.LocationSuggestion
import com.isaac.zomatobasic.data.models.LocationSuggestionResponse
import com.isaac.zomatobasic.data.models.helpers.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ZomatoApiService {
    //Not my key
    @Headers("user-key:1b3c8b37ea96785391fa55c288ac385c")
    @GET("/api/v2.1/locations")
    suspend fun getLocation(@Query("query") cityName: String) : LocationSuggestionResponse

    @Headers("user-key: 1b3c8b37ea96785391fa55c288ac385c")
    @GET("/api/v2.1/location_details")
    suspend fun getLocationDetails(@Query("entity_id") entityId: Int,
                                   @Query("entity_type") entityType: String) : LocationDetails

    ///api/v2.1/search?entity_id=280&entity_type=city&q=lombardi's
    @Headers("user-key: 1b3c8b37ea96785391fa55c288ac385c")
    @GET("/api/v2.1/search")
    suspend fun search(@Query("entity_id") entityId: Int,
                                   @Query("entity_type") entityType: String, @Query("q") searchString : String) : SearchResultResponse

}