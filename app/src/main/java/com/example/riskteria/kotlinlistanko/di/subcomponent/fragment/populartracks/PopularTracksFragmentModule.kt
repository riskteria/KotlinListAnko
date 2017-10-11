package com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.populartracks

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.riskteria.kotlinlistanko.di.module.FragmentModule
import com.example.riskteria.kotlinlistanko.di.scope.FragmentScope
import com.example.riskteria.kotlinlistanko.repository.TrackRepository
import com.example.riskteria.kotlinlistanko.ui.adapter.TracksAdapter
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragment
import dagger.Module
import dagger.Provides

/**
 * Created by riskteria on 10/11/17.
 */

@Module
class PopularTracksFragmentModule(fragment: PopularTracksFragment) : FragmentModule(fragment) {

    @Provides @FragmentScope
    fun provideAdapter(): TracksAdapter = TracksAdapter()

    @Provides @FragmentScope
    fun provideRepository(): TrackRepository = TrackRepository()

    @Provides @FragmentScope
    fun provideLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(fragment.context,
            LinearLayoutManager.VERTICAL, false)

}