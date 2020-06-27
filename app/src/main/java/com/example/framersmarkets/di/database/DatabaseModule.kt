package com.example.framersmarkets.di.database

import com.example.framersmarkets.data.market.MarketDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
@Module
object DatabaseModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideDatabase(): MarketDataSource {
        return MarketDataSource()
    }
}