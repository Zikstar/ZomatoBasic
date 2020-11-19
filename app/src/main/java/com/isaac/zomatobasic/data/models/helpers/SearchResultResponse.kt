package com.isaac.zomatobasic.data.models.helpers


import com.google.gson.annotations.SerializedName

data class SearchResultResponse(
    @SerializedName("restaurants")
    val restaurants: List<BestRatedRestaurant>,
    @SerializedName("results_found")
    val resultsFound: Int,
    @SerializedName("results_shown")
    val resultsShown: Int,
    @SerializedName("results_start")
    val resultsStart: Int
)