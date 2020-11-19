package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("text")
    val text: String
)