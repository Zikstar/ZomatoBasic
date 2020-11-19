package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName
import com.isaac.zomatobasic.data.models.helpers.Restaurant

data class BestRatedRestaurant(
    @SerializedName("restaurant")
    val restaurant: Restaurant
)