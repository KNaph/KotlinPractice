package com.tecace.retail.kotlinpractice.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.tecace.retail.kotlinpractice.R
import com.tecace.retail.kotlinpractice.pager.ImageAdapter
import java.io.File

class ImageGrid : Fragment() {

    val TAG = this.javaClass.simpleName

    private lateinit var imageGrid: GridView
    private lateinit var fileList: ArrayList<File>
    private lateinit var files: Array<File>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.fileList = ArrayList()
        initFiles()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_image_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.imageGrid = view.findViewById(R.id.image_gridview)

        this.imageGrid.adapter = this.context?.let { activity?.let { it1 -> ImageAdapter(it, this.fileList, it1) } }
    }

    private fun initFiles() {

        val completePath = this.context?.getExternalFilesDir("images")

        val dir = File(completePath.toString())
        files = dir.listFiles()

        for (file in files) {
//            Log.d(TAG, "KP## ${file.name}")
            fileList.add(file)
        }
    }
}