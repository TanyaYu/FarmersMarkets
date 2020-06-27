package com.example.framersmarkets.features.marketlist

import com.example.framersmarkets.base.viewmodel.RxViewModel
import com.example.framersmarkets.data.market.MarketDataSource
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketListViewModel @Inject constructor(
    private val marketDataSource: MarketDataSource
): RxViewModel() {

}