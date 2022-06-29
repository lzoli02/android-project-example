package com.zoltanlorinczi.project_retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoltanlorinczi.project_retrofit.App
import com.zoltanlorinczi.project_retrofit.api.MarketPlaceRepository
import com.zoltanlorinczi.project_retrofit.api.model.ProductResponse
import com.zoltanlorinczi.project_retrofit.manager.SharedPreferencesManager
import kotlinx.coroutines.launch

/**
 * Author:  Zoltan Lorinczi
 * Date:    12/6/2021
 */
class ListViewModel(private val repository: MarketPlaceRepository) : ViewModel() {

    companion object {
        private val TAG: String? = ListViewModel::class.java.canonicalName
    }

    var products: MutableLiveData<List<ProductResponse>> = MutableLiveData()

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                val token: String? = App.sharedPreferences.getStringValue(SharedPreferencesManager.KEY_TOKEN, "Empty token!")
                val result = token?.let { repository.getProducts(it) }
                products.value = result?.products
            } catch (e: Exception) {
                Log.e(TAG, "ListViewModel - getProducts() failed with exception: ${e.message}")
            }
        }
    }
}