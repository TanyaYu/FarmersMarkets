package com.example.framersmarkets.data.market

import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketDataSource @Inject constructor() {

    private val data = listOf(
        Market(1, "New Boston"),
        Market(2, "New Concord"),
        Market(3, "Manchester")
    )

    fun getMarkets(): Observable<List<Market>> {
        return Observable.just(data)
    }

    fun getById(id: Long): Observable<Market> {
        return Observable.just(data.find { it.id == id })
    }
}