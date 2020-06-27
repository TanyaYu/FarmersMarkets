package com.example.framersmarkets.features.marketdetails

import android.util.Log
import com.example.framersmarkets.base.viewmodel.RxViewModel
import com.example.framersmarkets.data.market.MarketDataSource
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class MarketDetailsViewModel @Inject constructor(
    private val marketDataSource: MarketDataSource
): RxViewModel() {

    private val idSubject: BehaviorSubject<Long> = BehaviorSubject.create()
    val id: Observable<Long> = idSubject.hide()

    fun setUp(id: Long) {
        idSubject.onNext(id)
    }

}
