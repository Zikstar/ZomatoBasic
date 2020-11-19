package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName

data class HasMenuStatus(
    @SerializedName("delivery")
    val delivery: Int,
    @SerializedName("takeaway")
    val takeaway: Int
)