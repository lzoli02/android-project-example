package com.zoltanlorinczi.project_retrofit

import android.app.Application
import android.util.Log

/**
 * Base class of Android app, containing components like Activities and Services.
 * Application or its subclasses are instantiated before all the activities or
 * any other application objects have been created in Android app.
 *
 * Author:  Zoltan Lorinczi
 * Date:    11/22/2021
 */
class App : Application() {

    companion object {
        private val TAG: String? = App::class.java.canonicalName
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() called!")
    }
}