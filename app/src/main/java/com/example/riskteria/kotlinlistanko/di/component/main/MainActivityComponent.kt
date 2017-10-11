package com.example.riskteria.kotlinlistanko.di.component.main

import com.example.riskteria.kotlinlistanko.di.scope.ActivityScope
import com.example.riskteria.kotlinlistanko.ui.screens.main.MainActivity
import dagger.Subcomponent

/**
 * Created by riskteria on 10/10/17.
 */

@ActivityScope
@Subcomponent(modules = arrayOf(
        MainActivityModule::class
))
interface MainActivityComponent {

    fun injectTo(activity: MainActivity)

}