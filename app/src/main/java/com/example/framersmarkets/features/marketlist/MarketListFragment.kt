package com.example.framersmarkets.features.marketlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.framersmarkets.R
import com.example.framersmarkets.features.marketdetails.MarketDetailsFragment
import com.example.framersmarkets.navigation.Navigation
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_market_list.*
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketListFragment : DaggerFragment() {

    @Inject
    lateinit var navigation: Navigation

    val model by viewModels<MarketListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_market_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        details.setOnClickListener {
            navigation.to(MarketDetailsFragment())
        }
    }
}