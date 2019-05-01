package com.tecace.retail.kotlinpractice

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent

class GestureListener : GestureDetector.SimpleOnGestureListener() {

    val TAG = this.javaClass.simpleName

    override fun onLongPress(e: MotionEvent?) {
        Log.d(TAG, "KP## Action onLongPress")

        super.onLongPress(e)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onSingleTapUp")
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onDoubleTap")

        return super.onDoubleTap(e)
    }
}