package com.example.framersmarkets.features.main

import android.os.Bundle
import com.example.framersmarkets.R
import com.example.framersmarkets.features.marketlist.MarketListFragment
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmets_container

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmets_container, MarketListFragment())
//            .addToBackStack()
            .commit()
    }
}