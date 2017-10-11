package com.example.riskteria.kotlinlistanko.di

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.example.riskteria.kotlinlistanko.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Created by riskteria on 10/10/17.
 */

@Module
abstract class ActivityModule(protected val activity: AppCompatActivity) {

    @Provides @ActivityScope
    fun provideActivity(): AppCompatActivity = activity

    @Provides @ActivityScope
    fun provideActivityContext(): Context = activity.baseContext

}