package com.example.framersmarkets.di.application

import com.example.framersmarkets.Application
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Author: Tanya Iuferova
 * Date: 6/25/20
 */
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ApplicationModule::class
])
@Singleton
interface ApplicationComponent : AndroidInjector<Application> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<Application>()
}