package com.example.riskteria.kotlinlistanko.di.module

import android.content.Context
import android.support.v4.app.Fragment
import com.example.riskteria.kotlinlistanko.di.scope.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by riskteria on 10/11/17.
 */

@Module
abstract class FragmentModule(protected val fragment: Fragment) {

    @Provides @FragmentScope
    fun provideFragment(): Fragment = fragment

    @Provides @FragmentScope
    fun provideFragmentContext(): Context = fragment.context

}