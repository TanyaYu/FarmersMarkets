package com.example.framersmarkets.di.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.framersmarkets.features.main.MainActivity
import dagger.Binds
import dagger.Module

/**
 * Author: Tanya Iuferova
 * Date: 6/25/20
 */
@Module
abstract class MainActivityModule {

    @Binds
    internal abstract fun provideMainActivity(activity: MainActivity): AppCompatActivity
}