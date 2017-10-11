package com.example.riskteria.kotlinlistanko.di

import com.example.riskteria.kotlinlistanko.App
import com.example.riskteria.kotlinlistanko.di.component.main.MainActivityComponent
import com.example.riskteria.kotlinlistanko.di.component.main.MainActivityModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by riskteria on 10/10/17.
 */

@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class
))
interface ApplicationComponent {

    fun inject(module: MainActivityModule): MainActivityComponent

}