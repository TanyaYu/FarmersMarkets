package com.example.framersmarkets.utils

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
object Schedulers {
    val main = AndroidSchedulers.mainThread()
    val computation = Schedulers.computation()
    val io = Schedulers.io()
}
