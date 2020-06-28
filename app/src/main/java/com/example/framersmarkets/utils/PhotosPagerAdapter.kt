package com.example.framersmarkets.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.transition.Transition

/**
 * Author: Tanya Iuferova
 * Date: 6/28/20
 */
open class PhotosPagerAdapter(
    private val options: RequestOptions = RequestOptions(),
    @DrawableRes private val backgroundPlaceHolder: Int? = null
) : PagerAdapter() {

    protected var photoUrls: List<String> = arrayListOf()

    var onItemClickListener: OnItemClickListener? = null

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        return ImageView(container.context).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            backgroundPlaceHolder?.let(::setBackgroundResource)

            val target = object : DrawableImageViewTarget(this) {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    getView().background = null
                    super.onResourceReady(resource, transition)
                }
            }.clearOnDetach()

            Glide.with(container.context)
                .load(photoUrls[position])
                .apply(options)
                .into(target)

            setOnClickListener {
                onItemClickListener?.onClick(position)
            }

            container.addView(this)
        }
    }

    override fun getCount(): Int {
        return photoUrls.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    fun submitList(photosUrls: List<String>) {
        this.photoUrls = photosUrls
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onClick(position: Int)
    }
}