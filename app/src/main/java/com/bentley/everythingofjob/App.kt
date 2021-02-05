package com.bentley.everythingofjob

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = applicationContext

        if (BuildConfig.DEBUG) {
                Stetho.initializeWithDefaults(this@App)
            }
    }

    companion object {
        private lateinit var instance: Context

        val globalApplicationContext: Context
            get() = instance
    }
}