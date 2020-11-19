package com.isaac.zomatobasic.data.models


import com.google.gson.annotations.SerializedName

data class LocationSuggestionResponse(
    @SerializedName("has_more")
    val hasMore: Int,
    @SerializedName("has_total")
    val hasTotal: Int,
    @SerializedName("location_suggestions")
    val locationSuggestions: List<LocationSuggestion>,
    @SerializedName("status")
    val status: String,
    @SerializedName("user_has_addresses")
    val userHasAddresses: Boolean
)