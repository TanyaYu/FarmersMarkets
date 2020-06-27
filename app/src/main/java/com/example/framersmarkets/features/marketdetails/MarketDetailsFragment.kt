package com.example.framersmarkets.features.marketdetails

import android.util.Log
import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.base.fragment.arg
import com.example.framersmarkets.base.fragment.withArguments

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketDetailsFragment : BaseFragment() {

    override val layout = R.layout.fragment_market_details
    private val viewModel by viewModels<MarketDetailsViewModel>()
    private val marketId: Long by arg(MARKET_ID)

    override fun onReady() {
        viewModel.setUp(marketId)
        viewModel.id.subscribe { Log.d("MarketDetailsFragment", "ID = $it") }
    }

    companion object {
        fun new(marketId: Long): MarketDetailsFragment {
            return MarketDetailsFragment().withArguments {
                putLong(MARKET_ID, marketId)
            }
        }

        private const val MARKET_ID = "MARKET_ID"
    }
}