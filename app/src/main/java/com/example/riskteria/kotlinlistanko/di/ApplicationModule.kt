package com.example.riskteria.kotlinlistanko.di

import android.content.Context
import com.example.riskteria.kotlinlistanko.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by riskteria on 10/10/17.
 */

@Module
class ApplicationModule(private val app: App) {

    @Provides @Singleton
    fun provideApplication(): App = app

    @Provides @Singleton @ApplicationQualifier
    fun provideApplicationContext(): Context = app

}