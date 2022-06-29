package com.zoltanlorinczi.project_retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zoltanlorinczi.project_retrofit.App
import com.zoltanlorinczi.project_retrofit.api.MarketPlaceRepository
import com.zoltanlorinczi.project_retrofit.api.model.LoginRequestBody
import com.zoltanlorinczi.project_retrofit.manager.SharedPreferencesManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Author:  Zoltan Lorinczi
 * Date:    11/8/2021
 */
class LoginViewModel(private val repository: MarketPlaceRepository) : ViewModel() {

    companion object {
        private val TAG: String? = LoginViewModel::class.java.canonicalName
    }

    var token: MutableLiveData<String> = MutableLiveData()
    var isSuccessful: MutableLiveData<Boolean> = MutableLiveData()

    fun login(userName: String, password: String) {
        val requestBody = LoginRequestBody(userName, password)
        viewModelScope.launch {
            executeLogin(requestBody)
        }
    }

    private suspend fun executeLogin(requestBody: LoginRequestBody) {
        try {
            val result = withContext(Dispatchers.IO) {
                repository.login(requestBody)
            }
            token.value = result.token
            App.sharedPreferences.putStringValue(SharedPreferencesManager.KEY_TOKEN, result.token)
            isSuccessful.value = true
            Log.d(TAG, "LoginViewModel - login response: $result")
        } catch (e: Exception) {
            Log.e(TAG, "LoginViewModel - login() failed with exception: ${e.message}")
            isSuccessful.value = false
        }
    }
}