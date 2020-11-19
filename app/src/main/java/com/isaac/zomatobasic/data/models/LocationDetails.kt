package com.isaac.zomatobasic.data.models
import com.isaac.zomatobasic.data.models.helpers.BestRatedRestaurant
import com.google.gson.annotations.SerializedName

data class LocationDetails(
    @SerializedName("best_rated_restaurant")
    val bestRatedRestaurant: List<BestRatedRestaurant>,
    @SerializedName("city")
    val city: String,
    @SerializedName("location")
    val location: LocationSuggestion,
    @SerializedName("nearby_res")
    val nearbyRes: List<String>,
    @SerializedName("nightlife_index")
    val nightlifeIndex: String,
    @SerializedName("nightlife_res")
    val nightlifeRes: String,
    @SerializedName("num_restaurant")
    val numRestaurant: Int,
    @SerializedName("popularity")
    val popularity: String,
    @SerializedName("popularity_res")
    val popularityRes: String,
    @SerializedName("subzone")
    val subzone: String,
    @SerializedName("subzone_id")
    val subzoneId: Int,
    @SerializedName("top_cuisines")
    val topCuisines: List<String>
)