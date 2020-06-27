package com.example.framersmarkets.features.marketdetails

import android.util.Log
import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.base.fragment.arg
import com.example.framersmarkets.base.fragment.withArguments
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy

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
        disposable += viewModel.market.subscribeBy(
            onNext = ::bindMarket,
            onError = ::onMarketError
        )
    }

    private fun bindMarket(market: MarketDetails) {
        Log.d(javaClass.simpleName, "ID = ${market.name}")
    }

    private fun onMarketError(throwable: Throwable) {
        Log.e(javaClass.simpleName, throwable.message ?: "")
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