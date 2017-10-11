package com.example.riskteria.kotlinlistanko.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.App
import com.example.riskteria.kotlinlistanko.di.ApplicationComponent
import com.example.riskteria.kotlinlistanko.ui.activity.ViewAnkoComponent

/**
 * Created by riskteria on 10/11/17.
 */
abstract class BaseFragment<out UI : ViewAnkoComponent<out ViewGroup>> : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies(App.applicationComponent)
    }

    abstract fun injectDependencies(applicationComponent: ApplicationComponent)

}