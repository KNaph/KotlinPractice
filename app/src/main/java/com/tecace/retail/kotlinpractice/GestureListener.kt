package com.tecace.retail.kotlinpractice

import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast

class GestureListener : GestureDetector.SimpleOnGestureListener() {

    val TAG = this.javaClass.simpleName

    override fun onLongPress(e: MotionEvent?) {
        Log.d(TAG, "KP## Action onLongPress")

        super.onLongPress(e)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onDown")

        return super.onDown(e)
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onSingleTapConfirmed")

        return true
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onSingleTapUp")
        return super.onSingleTapUp(e)
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        Log.d(TAG, "KP## Action onDoubleTap")

        return true
    }
}