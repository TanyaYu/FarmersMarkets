package com.example.framersmarkets.features.main

import android.os.Bundle
import com.example.framersmarkets.R
import com.example.framersmarkets.features.marketlist.MarketListFragment
import com.example.framersmarkets.navigation.Navigation
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigation: Navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null)
            navigation.new(MarketListFragment())
        else navigation.restore()
    }
}