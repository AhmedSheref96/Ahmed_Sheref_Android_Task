package com.el3asas.ahmed_sheref_android_task.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.el3asas.ahmed_sheref_android_task.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}