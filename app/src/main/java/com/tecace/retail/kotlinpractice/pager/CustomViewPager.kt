package com.tecace.retail.kotlinpractice.pager

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.util.Log

class CustomViewPager : ViewPager {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

//    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//
//        var newWidthMeasureSpec = widthMeasureSpec
//        var newHeightMeasureSpec = heightMeasureSpec
//
//
//        var height = 0
//        for (i in 0..childCount) {
//            val child = getChildAt(i) ?: break
//            Log.d("exception", "No exception plz : $child : $childCount")
//            child.measure(newWidthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED))
//            var h = child.measuredHeight
//            if (h > height) height = h
//        }
//
//        if (height != 0) {
//            newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY)
//        }
//
//        super.onMeasure(newWidthMeasureSpec, newHeightMeasureSpec)
//    }
}