package com.example.framersmarkets.di.activity

import com.example.framersmarkets.features.marketlist.MarketListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    internal abstract fun bindMarketListFragment(): MarketListFragment
}