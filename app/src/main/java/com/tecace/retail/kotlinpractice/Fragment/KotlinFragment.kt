package com.tecace.retail.kotlinpractice.Fragment

import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tecace.retail.kotlinpractice.R
import kotlinx.android.synthetic.main.fragment_calculator.*
import java.io.File

class KotlinFragment : Fragment() {

    val TAG = this.javaClass.simpleName

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
        Glide.with(this).load(image).thumbnail(pHolder).into(fragmentImage)
    }

    fun onClick() {
        val num1 = num1ET.text.toString()
        val num2 = num2ET.text.toString()
        val result = num1.toFloat() + num2.toFloat()

        resultTV.text = "Result: " + result.toString()
    }
}