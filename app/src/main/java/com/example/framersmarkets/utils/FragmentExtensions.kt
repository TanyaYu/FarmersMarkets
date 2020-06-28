package com.example.framersmarkets.utils

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Author: Tanya Iuferova
 * Date: 6/26/20
 */
inline fun <F : Fragment> F.withArguments(block: Bundle.() -> Unit) = this.apply {
    arguments = Bundle().apply(block)
}

inline fun <reified T : Any, F : Fragment> F.getArg(key: String): T {
    return (arguments?.get(key)
        ?: NullPointerException("No argument for key [$key] in ${this::class.java.simpleName}")) as T
}

inline fun <reified T : Any, F : Fragment> F.getArg(key: String, defaultValue: T): T {
    return arguments?.get(key) as? T ?: defaultValue
}

inline fun <reified T : Any, F : Fragment> F.arg(key: String) = lazy { getArg<T, F>(key) }

inline fun <reified T : Any, F : Fragment> F.arg(key: String, defaultValue: T) = lazy { getArg(key, defaultValue) }
