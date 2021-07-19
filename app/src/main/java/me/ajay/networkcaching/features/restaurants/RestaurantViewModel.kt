package me.ajay.networkcaching.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.ajay.networkcaching.api.RestaurantApi
import me.ajay.networkcaching.data.Restaurant
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    api: RestaurantApi
) : ViewModel() {
    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData
    // the restaurantsLiveData is assigned to restaurants
    // because we have made restaurantsLiveData as private
    // as it is mutable it should get modified only by the
    // viewModel not by the activity that's why we made it private
    // so the activity should not access it, to access the data activity will use
    // <b>restaurants</b> which can read the value but can't modify it.

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants()
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }
}