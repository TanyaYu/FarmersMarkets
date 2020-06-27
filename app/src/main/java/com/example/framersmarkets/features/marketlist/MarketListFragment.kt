package com.example.framersmarkets.features.marketlist

import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.features.marketdetails.MarketDetailsFragment
import kotlinx.android.synthetic.main.fragment_market_list.*

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketListFragment : BaseFragment() {

    override val layout = R.layout.fragment_market_list
    private val viewModel by viewModels<MarketListViewModel>()

    override fun onReady() {
        details.setOnClickListener {
            navigation.to(MarketDetailsFragment.new(1))
        }
    }
}