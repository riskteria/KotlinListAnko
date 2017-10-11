package com.example.riskteria.kotlinlistanko.di.subcomponent.activity.main

import com.example.riskteria.kotlinlistanko.di.module.ActivityModule
import com.example.riskteria.kotlinlistanko.di.scope.ActivityScope
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragment
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragment
import com.example.riskteria.kotlinlistanko.ui.presenter.MainPresenter
import com.example.riskteria.kotlinlistanko.ui.screens.main.MainActivity
import com.example.riskteria.kotlinlistanko.ui.view.MainView
import dagger.Module
import dagger.Provides

/**
 * Created by riskteria on 10/10/17.
 */

@Module
class MainActivityModule(activity: MainActivity) : ActivityModule(activity) {

    @Provides @ActivityScope
    fun provideMainView(): MainView = activity as MainView

    @Provides @ActivityScope
    fun provideMainPresenter(view: MainView) = MainPresenter(view)

    @Provides @ActivityScope
    fun providePopularArtistsFragment() = PopularArtistsFragment()

    @Provides @ActivityScope
    fun providePopularTracksFragment() = PopularTracksFragment()

}