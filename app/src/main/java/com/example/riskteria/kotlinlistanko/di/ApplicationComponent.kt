package com.example.riskteria.kotlinlistanko.di

import com.example.riskteria.kotlinlistanko.di.module.ApplicationModule
import com.example.riskteria.kotlinlistanko.di.subcomponent.activity.main.MainActivityComponent
import com.example.riskteria.kotlinlistanko.di.subcomponent.activity.main.MainActivityModule
import com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.popularartists.PopularArtistsFragmentComponent
import com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.popularartists.PopularArtistsFragmentModule
import com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.populartracks.PopularTracksFragmentComponent
import com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.populartracks.PopularTracksFragmentModule
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
    fun inject(module: PopularArtistsFragmentModule): PopularArtistsFragmentComponent
    fun inject(module: PopularTracksFragmentModule): PopularTracksFragmentComponent

}