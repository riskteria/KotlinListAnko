package com.example.riskteria.kotlinlistanko

import android.app.Application
import com.example.riskteria.kotlinlistanko.di.ApplicationComponent
import com.example.riskteria.kotlinlistanko.di.ApplicationModule
import com.example.riskteria.kotlinlistanko.di.DaggerApplicationComponent

/**
 * Created by riskteria on 10/10/17.
 */
class App : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}