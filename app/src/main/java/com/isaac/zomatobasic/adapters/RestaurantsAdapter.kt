package com.isaac.zomatobasic.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isaac.zomatobasic.data.models.helpers.Restaurant
import com.isaac.zomatobasic.databinding.ItemRestaurantBinding
import java.util.ArrayList

class RestaurantsAdapter(private val restaurants: List<Restaurant>) :
    RecyclerView.Adapter<RestaurantsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        return RestaurantsViewHolder(
            ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.binding.restaurant = restaurants[position]
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Glide.with(view).load(imageUrl).into(view);
}



class RestaurantsViewHolder(val binding: ItemRestaurantBinding) :
    RecyclerView.ViewHolder(binding.root)