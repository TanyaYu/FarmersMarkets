package com.example.framersmarkets.utils

import androidx.viewpager.widget.ViewPager

/**
 * Author: Tanya Iuferova
 * Date: 6/28/20
 */
fun ViewPager.addOnPageChangeListener(block: (position: Int) -> Unit) {
    addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            block(position)
        }
    })
}