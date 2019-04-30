package com.tecace.retail.kotlinpractice.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.GestureDetectorCompat
import android.util.Log
import android.view.*
import android.widget.Toast
import com.bumptech.glide.Glide
import com.tecace.retail.kotlinpractice.GestureListener
import com.tecace.retail.kotlinpractice.R
import com.tecace.retail.kotlinpractice.pager.CustomViewPager
import kotlinx.android.synthetic.main.fragment_image_collection.*
import java.io.File

class KotlinFragment : Fragment() {

    val TAG = this.javaClass.simpleName

    private lateinit var imageCollectionPagerAdapter: ImageCollectionPagerAdapter
    private lateinit var viewPager: CustomViewPager
    private var primaryImage: Int = 0
    private lateinit var files: Array<File>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            primaryImage = arguments!!.getInt("primaryImage") // TODO: NULL???
        }
        initFiles()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_image_focus, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager = view.findViewById(R.id.fragment_pager)
        imageCollectionPagerAdapter = ImageCollectionPagerAdapter(childFragmentManager, files)
        viewPager.adapter = imageCollectionPagerAdapter
        viewPager.currentItem = primaryImage
    }

    private fun initFiles() {

        val completePath = this.context?.getExternalFilesDir("images")

        val dir = File(completePath.toString())
        files = dir.listFiles()
    }
}


class ImageCollectionPagerAdapter(fm: FragmentManager, fileArray: Array<File>) : FragmentStatePagerAdapter(fm) {

    private val files = fileArray

    override fun getItem(p0: Int): Fragment {
        val fragment = ImageObjectFragment()
        fragment.arguments = Bundle().apply {
            // Our object is just an integer :-P
            putString(ARG_IMAGE, files[p0].absolutePath)
        }
        return fragment
    }

    override fun getCount(): Int {
        return files.size
    }
}

private const val ARG_IMAGE = "image"

class ImageObjectFragment : Fragment() {

    val TAG = this.javaClass.simpleName


    private lateinit var scaleDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_IMAGE) }?.apply {
            val image = File(getString(ARG_IMAGE))
            if (image.extension == "gif") {
                context?.let { Glide.with(it).asGif().load(image).into(pager_image_box) }
            } else {
                context?.let { Glide.with(it).load(image).into(pager_image_box) }
            }
        }

        val customGestureListener = GestureListener()

        val gesture = GestureDetector(activity, customGestureListener)

        // Listener doesn't do anything?
        gesture.setOnDoubleTapListener(object : GestureDetector.OnDoubleTapListener {
            override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return true
            }

            override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return true
            }

            override fun onDoubleTap(e: MotionEvent?): Boolean {
                Log.d(TAG, "KP## DOUBLE TAP EVENT?")
                return true
            }
        })

        pager_image_box.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                when (event?.action) {
//                    MotionEvent.ACTION_DOWN -> Toast.makeText(context, "TOUCHED IMAGE...? ", Toast.LENGTH_LONG).show()
//                }
//
//                return v?.onTouchEvent(event) ?: true

                return gesture.onTouchEvent(event)

//                return when (event?.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        Log.d(TAG, "Action was DOWN")
//                        pager_image_box.scaleX = pager_image_box.scaleX*2
//                        pager_image_box.scaleY = pager_image_box.scaleY*2
//                        true
//                    }
//                    MotionEvent.ACTION_MOVE -> {
//                        Log.d(TAG, "Action was MOVE")
//                        true
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        Log.d(TAG, "Action was UP")
//                        pager_image_box.scaleX = pager_image_box.scaleX/2
//                        pager_image_box.scaleY = pager_image_box.scaleY/2
//                        true
//                    }
//                    MotionEvent.ACTION_CANCEL -> {
//                        Log.d(TAG, "Action was CANCEL")
//                        true
//                    }
//                    MotionEvent.ACTION_OUTSIDE -> {
//                        Log.d(TAG, "Movement occurred outside bounds of current screen element")
//                        true
//                    }
//                    else -> false
//                }
            }
        })
    }
}