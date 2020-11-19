package com.isaac.zomatobasic

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.isaac.zomatobasic.data.models.helpers.Restaurant
import com.isaac.zomatobasic.data.networkHelpers.ResultWrapper

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var query = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.searchResultsLiveData.observe(this, Observer {
            if(it != null && it is ResultWrapper.Success){
                val searchResult = it.value
                val bestRestaurants = searchResult.restaurants

                if(bestRestaurants.isNotEmpty()){
                    val restaurants = arrayListOf<Restaurant>()
                    for (bestRestaurant in bestRestaurants){
                        restaurants.add(bestRestaurant.restaurant)
                    }

                    startFragment(SearchFragment.newInstance(restaurants, query),
                        addToBackStack = true,
                        allowStateLoss = false
                    )
                }


            }
        })



        handleIntent(intent)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu?.findItem(R.id.search)?.actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }
        return true
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if(intent != null){
            handleIntent(intent)
        }
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            query = intent.getStringExtra(SearchManager.QUERY)!!
            //use the query to search your data somehow

            viewModel.searchForRestaurant(query)
            Toast.makeText(this, "Searching", Toast.LENGTH_SHORT).show()
        }
    }


    private fun startFragment(
        fragment: Fragment?,
        addToBackStack: Boolean,
        allowStateLoss: Boolean
    ) {
        if (fragment != null) {
            val fManager = supportFragmentManager
            if (!fManager.isStateSaved) {
                val ft = fManager.beginTransaction()
                ft.replace(R.id.nav_host_fragment, fragment, fragment.javaClass.name)
                if (addToBackStack) {
                    ft.addToBackStack(fragment.javaClass.name)
                }
                if (allowStateLoss) {
                    ft.commitAllowingStateLoss()
                } else {
                    ft.commit()
                }
            }
        }
    }
}