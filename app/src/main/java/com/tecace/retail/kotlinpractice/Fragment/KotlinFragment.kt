package com.tecace.retail.kotlinpractice.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tecace.retail.kotlinpractice.R
import com.tecace.retail.kotlinpractice.pager.CustomViewPager
import kotlinx.android.synthetic.main.fragment_calculator.*
import kotlinx.android.synthetic.main.fragment_image_collection.*
import java.io.File

class KotlinFragment : Fragment() {

    val TAG = this.javaClass.simpleName

    private lateinit var imageCollectionPagerAdapter: ImageCollectionPagerAdapter
    private lateinit var viewPager: CustomViewPager
    private var primaryImage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            primaryImage = savedInstanceState.getInt("primaryImage")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calcBtn.setOnClickListener {
            onClick()
        }

//        val rawImage = this.context.assets.

        val completePath = this.context?.getExternalFilesDir("images")

        val dir = File(completePath.toString())
        val files = dir.listFiles()

        for (file in files)
            Log.d(TAG, "KP## ${file.name}")

//        val image = File(completePath.toString() + "/IMG_20180520_103356.dng")
        val image = File(completePath.toString() + "/IMG_8924.CR2")
        Log.d(TAG, "PATH : $completePath : $image")
        val pHolder = 0.25f
//        Glide.with(this).load(image).thumbnail(pHolder).into(fragmentImage)

        imageCollectionPagerAdapter = ImageCollectionPagerAdapter(childFragmentManager, files)
        imageCollectionPagerAdapter.setPrimaryItem(view, primaryImage, Any())
        viewPager = view.findViewById(R.id.fragment_pager)
        viewPager.adapter = imageCollectionPagerAdapter
    }

    private fun onClick() {
        val num1 = num1ET.text.toString()
        val num2 = num2ET.text.toString()
        val result = num1.toFloat() + num2.toFloat()

        resultTV.text = "Result: " + result.toString()
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_collection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
        arguments?.takeIf { it.containsKey(ARG_IMAGE) }?.apply {
            val image = File(getString(ARG_IMAGE))
            context?.let { Glide.with(it).load(image).into(pager_image_box) }
        }
    }
}