package com.isaac.zomatobasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.isaac.zomatobasic.adapters.RestaurantsAdapter
import com.isaac.zomatobasic.data.models.helpers.Restaurant
import com.isaac.zomatobasic.data.networkHelpers.ResultWrapper
import kotlinx.android.synthetic.main.fragment_landing.*

class LandingFragment: Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.locationData.observe(viewLifecycleOwner, Observer { wrappedLocationResponse ->
            if (wrappedLocationResponse!= null && wrappedLocationResponse is ResultWrapper.Success){
                val locationResponse = wrappedLocationResponse.value

                if(locationResponse.locationSuggestions.isNotEmpty()){
                    val entityId = locationResponse.locationSuggestions[0].entityId
                    val entityType = locationResponse.locationSuggestions[0].entityType
                    viewModel.getLocationDetails(entityId, entityType)
                }

            }else{
                Toast.makeText(context, "There Was an error", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.locationDetailsLiveData.observe(viewLifecycleOwner, Observer {
            if(it != null && it is ResultWrapper.Success){
                tv_test.visibility = View.GONE
                val locationDetails = it.value
                val bestRestaurants = locationDetails.bestRatedRestaurant
                val restaurants = arrayListOf<Restaurant>()
                for (bestRestaurant in bestRestaurants){
                    restaurants.add(bestRestaurant.restaurant)
                }

                val adapter = RestaurantsAdapter(restaurants)
                rv_restaurants.adapter = adapter

            }else{
                Toast.makeText(context, "There Was an error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}