package me.ajay.networkcaching.features.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import me.ajay.networkcaching.data.RestaurantRepository
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(
    repository: RestaurantRepository
) : ViewModel() {
    val restaurants = repository.getRestaurants().asLiveData()

/*    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData
    // the restaurantsLiveData is assigned to restaurants
    // because we have made restaurantsLiveData as private
    // as it is mutable it should get modified only by the
    // viewModel not by the activity that's why we made it private
    // so the activity should not access it, to access the data activity will use
    // <b>restaurants</b> which can read the value but can't modify it.

    init {
        viewModelScope.launch {
        // api can be get from the constructor
            val restaurants = api.getRestaurants()
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }*/
}
