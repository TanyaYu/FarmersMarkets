package com.example.framersmarkets.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.framersmarkets.R
import com.example.framersmarkets.features.main.MainActivity
import com.example.framersmarkets.navigation.Navigation
import dagger.Binds
import dagger.Module
import dagger.Provides

/**
 * Author: Tanya Iuferova
 * Date: 6/25/20
 */
@Module
abstract class MainActivityModule {

    @Binds
    internal abstract fun provideMainActivity(activity: MainActivity): AppCompatActivity

    @Module companion object {
        @Provides
        @ActivityScope
        @JvmStatic
        fun provideNavigation(activity: AppCompatActivity) : Navigation {
            return Navigation(R.id.fragmets_container, activity.supportFragmentManager)
        }
    }
}