package com.example.framersmarkets.base.viewmodel

import androidx.annotation.CallSuper
import io.reactivex.rxjava3.disposables.CompositeDisposable

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
open class RxViewModel : ViewModel() {
    val disposable = CompositeDisposable()

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}