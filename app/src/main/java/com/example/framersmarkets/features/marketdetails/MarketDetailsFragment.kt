package com.example.framersmarkets.features.marketdetails

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
class MarketDetailsFragment: DaggerFragment() {

    val model by viewModels<MarketDetailsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_market_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}