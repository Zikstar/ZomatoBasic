package com.isaac.zomatobasic.data.models.helpers
import com.google.gson.annotations.SerializedName
import com.isaac.zomatobasic.data.models.helpers.HasMenuStatus

data class R(
    @SerializedName("has_menu_status")
    val hasMenuStatus: HasMenuStatus,
    @SerializedName("is_grocery_store")
    val isGroceryStore: Boolean,
    @SerializedName("res_id")
    val resId: Int
)