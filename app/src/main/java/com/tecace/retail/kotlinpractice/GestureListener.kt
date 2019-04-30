package com.tecace.retail.kotlinpractice

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast

class GestureListener : GestureDetector.SimpleOnGestureListener() {

    val TAG = this.javaClass.simpleName

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        Log.d(TAG, "KP## Action onFling")
        return super.onFling(e1, e2, velocityX, velocityY)
    }

    override fun onLongPress(e: MotionEvent?) {
        Log.d(TAG, "KP## Action onLongPress")

        super.onLongPress(e)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onSingleTapConfirmed")

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