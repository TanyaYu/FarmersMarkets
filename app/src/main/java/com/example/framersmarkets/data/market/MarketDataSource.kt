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
        Market(2, "Concord"),
        Market(3, "Manchester"),
        Market(4, "Nashua"),
        Market(5, "Londonderry"),
        Market(6, "Derry"),
        Market(7, "Salem"),
        Market(8, "Portsmouth"),
        Market(9, "Boston"),
        Market(10, "Conway"),
        Market(11, "North Conway"),
        Market(12, "Laconia"),
        Market(13, "Washington"),
        Market(14, "Derryfield"),
        Market(15, "Tyumen")
    )

    fun getMarkets(): Observable<List<Market>> {
        return Observable.just(data)
    }

    fun getById(id: Long): Observable<Market> {
        return Observable.just(data.find { it.id == id })
    }
}