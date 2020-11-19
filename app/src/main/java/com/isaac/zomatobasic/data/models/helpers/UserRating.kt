package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName
import com.isaac.zomatobasic.data.models.helpers.RatingObj

data class UserRating(
    @SerializedName("aggregate_rating")
    val aggregateRating: String,
    @SerializedName("rating_color")
    val ratingColor: String,
    @SerializedName("rating_obj")
    val ratingObj: RatingObj,
    @SerializedName("rating_text")
    val ratingText: String,
    @SerializedName("votes")
    val votes: Int
)