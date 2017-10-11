package com.example.riskteria.kotlinlistanko.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.riskteria.kotlinlistanko.App
import com.example.riskteria.kotlinlistanko.di.ApplicationComponent
import org.jetbrains.anko.setContentView

/**
 * Created by riskteria on 9/18/17.
 */

abstract class BaseActivity<out UI : ActivityAnkoComponent<out AppCompatActivity>> : AppCompatActivity() {

    abstract val ui: UI

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(App.applicationComponent)
        (ui as ActivityAnkoComponent<AppCompatActivity>).setContentView(this)
        setSupportActionBar(ui.toolbar)
    }

    abstract fun injectDependencies(applicationComponent: ApplicationComponent)

}