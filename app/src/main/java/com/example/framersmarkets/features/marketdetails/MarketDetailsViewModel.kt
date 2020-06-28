package com.example.framersmarkets.features.marketdetails

import com.example.framersmarkets.base.viewmodel.ViewModel
import com.example.framersmarkets.data.market.Market
import com.example.framersmarkets.data.market.MarketDataSource
import com.example.framersmarkets.data.market.toDetails
import com.example.framersmarkets.utils.Schedulers.computation
import com.example.framersmarkets.utils.Schedulers.main
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketDetailsViewModel @Inject constructor(
    private val marketDataSource: MarketDataSource
): ViewModel() {

    private val idSubject: BehaviorSubject<Long> = BehaviorSubject.create()
    val id: Observable<Long> = idSubject.hide()

    val market = id.flatMap(marketDataSource::getById)
        .map(Market::toDetails)

    val farms = market.map { it.farms }

    fun setUp(id: Long) {
        idSubject.onNext(id)
    }

}
