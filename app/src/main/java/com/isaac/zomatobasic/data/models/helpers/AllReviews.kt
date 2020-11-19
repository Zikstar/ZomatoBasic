package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName

data class AllReviews(
    @SerializedName("reviews")
    val reviews: List<Review>
)