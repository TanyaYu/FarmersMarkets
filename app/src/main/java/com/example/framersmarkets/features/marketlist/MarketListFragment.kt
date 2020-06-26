package com.example.framersmarkets.features.marketlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.framersmarkets.R
import dagger.android.support.DaggerFragment

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketListFragment : DaggerFragment() {

    val model by viewModels<MarketListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_market_list, container, false)
    }
}