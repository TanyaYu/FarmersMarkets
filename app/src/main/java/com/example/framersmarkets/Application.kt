package com.example.framersmarkets

import com.example.framersmarkets.di.application.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Author: Tanya Iuferova
 * Date: 6/25/20
 */
class Application : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .builder()
            .create(this)
    }
}