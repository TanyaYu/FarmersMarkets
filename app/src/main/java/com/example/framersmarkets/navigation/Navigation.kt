package com.example.framersmarkets.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
class Navigation(
    @IdRes private val containerId: Int,
    private val fragmentManager: FragmentManager
) {

    fun new(fragment: Fragment, tag: String = fragment.javaClass.simpleName) {
        fragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .commit()
    }

    fun to(fragment: Fragment, tag: String = fragment.javaClass.simpleName) {
        fragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .addToBackStack(tag)
            .commit()
    }

    fun back() {
        fragmentManager.popBackStack()
    }

    fun restore() {
        fragmentManager.executePendingTransactions()
    }
}