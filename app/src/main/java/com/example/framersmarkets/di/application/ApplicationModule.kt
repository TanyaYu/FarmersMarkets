package com.example.framersmarkets.di.application

import android.content.Context
import com.example.framersmarkets.Application
import com.example.framersmarkets.features.main.MainActivity
import com.example.framersmarkets.di.activity.ActivityScope
import com.example.framersmarkets.di.activity.FragmentBuildersModule
import com.example.framersmarkets.di.activity.MainActivityModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Author: Tanya Iuferova
 * Date: 6/25/20
 */
@Module
abstract class ApplicationModule {

    @Binds
    internal abstract fun provideContext(application: Application): Context

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuildersModule::class])
    @ActivityScope
    internal abstract fun bindMainActivity(): MainActivity
}