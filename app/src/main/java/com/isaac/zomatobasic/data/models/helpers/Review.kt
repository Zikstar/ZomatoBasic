package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName

data class Review(
    @SerializedName("review")
    val review: List<Any>
)