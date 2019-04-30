package com.tecace.retail.kotlinpractice.pager

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentTransitionImpl
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tecace.retail.kotlinpractice.Fragment.KotlinFragment
import com.tecace.retail.kotlinpractice.R
import com.tecace.retail.kotlinpractice.view.CustomGridViewItem
import java.io.File

class ImageAdapter : BaseAdapter {

    val TAG = this.javaClass.simpleName


    private var context: Context
    private var fileList: ArrayList<File>
    private var activity: FragmentActivity

    constructor(context: Context, fileList: ArrayList<File>, activity: FragmentActivity) {
        this.context = context
        this.fileList = fileList
        this.activity = activity
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var imageView: CustomGridViewItem

        if(convertView == null) {
            imageView = CustomGridViewItem(this.context)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setBackgroundColor(Color.CYAN)
        } else {
            imageView = convertView as CustomGridViewItem
        }

//        val windowManager = context.getSystemService(Context.Window)
        val display = (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay
        val size = Point()

        display.getSize(size)

        val requestOps = RequestOptions().override(size.x/4)

        Glide.with(this.context)
            .load(this.fileList[position])
            .apply(requestOps)
            .thumbnail(0.25f)
            .dontAnimate()
            .into(imageView)

        imageView.setOnClickListener {
//            Toast.makeText(this.context, "CLICKED: $position", Toast.LENGTH_LONG).show()

            val bundle = Bundle()
            bundle.putInt("primaryImage", position)

            val imageFragment = KotlinFragment()
            imageFragment.arguments = bundle // TODO: Sending null position?

          /*
          * Referring to
          * https://developer.android.com/training/animation/zoom - Tap to zoom
          * Pinch zoom functionality
          * */


            activity.supportFragmentManager.beginTransaction().replace(R.id.content_frame, imageFragment, "ImageFragment: $position")
//                .setTransition()
                .addToBackStack(null)
                .commit()

        }

        return imageView
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return this.fileList.size
    }

}