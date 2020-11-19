package com.isaac.zomatobasic.data.models.helpers


import com.google.gson.annotations.SerializedName

data class LocationX(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("city_id")
    val cityId: Int,
    @SerializedName("country_id")
    val countryId: Int,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("locality")
    val locality: String,
    @SerializedName("locality_verbose")
    val localityVerbose: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("zipcode")
    val zipcode: String
)