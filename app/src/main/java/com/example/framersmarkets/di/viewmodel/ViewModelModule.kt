package com.example.framersmarkets.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.framersmarkets.features.marketdetails.MarketDetailsViewModel
import com.example.framersmarkets.features.marketlist.MarketListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MarketListViewModel::class)
    internal abstract fun bindMarketListViewModel(viewModel: MarketListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MarketDetailsViewModel::class)
    internal abstract fun bindMarketDetailsViewModel(viewModel: MarketDetailsViewModel): ViewModel

}