package com.example.framersmarkets.features.marketlist

import android.util.Log
import com.example.framersmarkets.R
import com.example.framersmarkets.base.fragment.BaseFragment
import com.example.framersmarkets.features.marketdetails.MarketDetailsFragment
import io.reactivex.rxjava3.kotlin.plusAssign
import io.reactivex.rxjava3.kotlin.subscribeBy
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
        disposable += viewModel.markets.subscribeBy(
            onNext = ::bindMarketsList,
            onError = ::onMarketListError
        )
    }

    private fun bindMarketsList(markets: List<MarketItem>) {
        Log.d(javaClass.simpleName, markets.toString())
    }

    private fun onMarketListError(throwable: Throwable) {
        Log.d(javaClass.simpleName, throwable.message ?: "")
    }
}