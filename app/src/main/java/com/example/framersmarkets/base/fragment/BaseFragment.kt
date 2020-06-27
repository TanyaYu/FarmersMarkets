package com.example.framersmarkets.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.framersmarkets.base.viewmodel.ViewModel
import com.example.framersmarkets.navigation.Navigation
import dagger.android.support.DaggerFragment
import javax.inject.Inject

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
abstract class BaseFragment : DaggerFragment() {

    abstract val layout: Int

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigation: Navigation

    inline fun <reified VM : ViewModel> viewModels() = viewModels<VM>(factoryProducer = { viewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onReady()
    }

    open fun onReady() {

    }
}