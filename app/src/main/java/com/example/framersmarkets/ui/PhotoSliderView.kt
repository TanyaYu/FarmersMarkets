package com.example.framersmarkets.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.withStyledAttributes
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.request.RequestOptions
import com.example.framersmarkets.R
import com.example.framersmarkets.utils.PhotosPagerAdapter
import com.example.framersmarkets.utils.addOnPageChangeListener

/**
 * Author: Tanya Iuferova
 * Date: 6/28/20
 */
class PhotoSliderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.photoSliderStyle
) : FrameLayout(context, attrs, defStyleAttr) {

    private val pager: ViewPager
    private val counter: TextView
    private val adapter = PhotosPagerAdapter(RequestOptions().centerCrop())

    var count: Int = 0
        set(value) {
            field = value
            updateCounterText()
        }

    var currentIndex: Int = 0
        set(value) {
            field = value
            updateCounterText()
        }

    init {
        inflate(context, R.layout.view_photo_slider, this)

        pager = findViewById(R.id.pager)
        counter = findViewById(R.id.counter)

        pager.adapter = adapter
        pager.addOnPageChangeListener { position ->
            currentIndex = position
        }

        context.withStyledAttributes(attrs, R.styleable.PhotoSliderView, defStyleAttr) {
            getInteger(R.styleable.PhotoSliderView_count, 0)
        }
    }

    fun submitPhotos(photos: List<String>) {
        adapter.submitList(photos)
    }

    private fun updateCounterText() {
        counter.text = resources.getString(
            R.string.photo_slider_counter_template,
            currentIndex + 1,
            count
        )
    }
}

