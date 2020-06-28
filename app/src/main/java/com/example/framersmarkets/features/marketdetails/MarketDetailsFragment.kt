package com.example.framersmarkets.features.marketdetails

import android.util.Log
import android.widget.Toast
import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.utils.arg
import com.example.framersmarkets.utils.withArguments
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_market_details.*

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
        name_tv.text = market.name
        id_tv.text = market.id
    }

    private fun onMarketError(throwable: Throwable) {
        Log.e(javaClass.simpleName, throwable.message ?: "")
        Toast.makeText(requireContext(), R.string.error, Toast.LENGTH_SHORT).show()
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