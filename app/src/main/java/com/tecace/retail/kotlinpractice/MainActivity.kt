package com.tecace.retail.kotlinpractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.tecace.retail.kotlinpractice.Fragment.ImageGrid
import com.tecace.retail.kotlinpractice.Fragment.KotlinFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var transaction = supportFragmentManager.beginTransaction()

        val kotlinFragment = KotlinFragment()
        val imageGrid = ImageGrid()

//        transaction.replace(R.id.content_frame, kotlinFragment).commit()
        transaction.replace(R.id.content_frame, imageGrid).commit()

    }
}
