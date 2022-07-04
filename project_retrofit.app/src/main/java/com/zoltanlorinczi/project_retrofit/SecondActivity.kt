package com.zoltanlorinczi.project_retrofit

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zoltanlorinczi.project_retorfit.databinding.ActivitySecondBinding

/**
 * Author:  Zoltan Lorinczi
 * Date:    7/4/2022
 */
class SecondActivity : AppCompatActivity() {

    companion object {
        private val TAG: String? = SecondActivity::class.java.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate() called!")

        val binding: ActivitySecondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called!")
    }
}