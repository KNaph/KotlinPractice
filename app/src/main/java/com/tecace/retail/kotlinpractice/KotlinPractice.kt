package com.tecace.retail.kotlinpractice

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KotlinPractice : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
        startKoin {
            androidLogger()
            androidContext(this@KotlinPractice)
            modules(appModule)
        }
    }
}