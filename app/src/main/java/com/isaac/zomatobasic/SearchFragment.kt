package com.isaac.zomatobasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.isaac.zomatobasic.adapters.RestaurantsAdapter
import com.isaac.zomatobasic.data.models.helpers.Restaurant
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {
    private lateinit var restaurants: List<Restaurant>
    private lateinit var query: String

    companion object{
        fun newInstance(restaurants: List<Restaurant>, query: String):SearchFragment {
            val args = Bundle()
            val fragment = SearchFragment()
            fragment.restaurants = restaurants
            fragment.query = query
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "Search Results For : $query"
        tv_search.text = text
        val adapter = RestaurantsAdapter(restaurants)
        rv_restaurants.adapter = adapter
    }
}