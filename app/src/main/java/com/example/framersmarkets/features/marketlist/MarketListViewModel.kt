package com.example.framersmarkets.features.marketlist

import com.example.framersmarkets.base.viewmodel.ViewModel
import com.example.framersmarkets.data.market.Market
import com.example.framersmarkets.data.market.MarketDataSource
import com.example.framersmarkets.data.market.toItem
import com.example.framersmarkets.utils.Schedulers.computation
import com.example.framersmarkets.utils.Schedulers.main
import com.example.framersmarkets.utils.mapList
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketListViewModel @Inject constructor(
    private val marketDataSource: MarketDataSource
): ViewModel() {

    val markets = marketDataSource.getMarkets()
        .mapList(Market::toItem)
        .subscribeOn(computation)
        .observeOn(main)
}