package com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.popularartists

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.riskteria.kotlinlistanko.di.module.FragmentModule
import com.example.riskteria.kotlinlistanko.di.scope.FragmentScope
import com.example.riskteria.kotlinlistanko.repository.ArtistRepository
import com.example.riskteria.kotlinlistanko.ui.adapter.ArtistsAdapter
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragment
import dagger.Module
import dagger.Provides

/**
 * Created by riskteria on 10/11/17.
 */

@Module
class PopularArtistsFragmentModule(fragment: PopularArtistsFragment) : FragmentModule(fragment) {

    @Provides @FragmentScope
    fun provideAdapter(): ArtistsAdapter = ArtistsAdapter()

    @Provides @FragmentScope
    fun provideRepository(): ArtistRepository = ArtistRepository()

    @Provides @FragmentScope
    fun provideLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(fragment.context,
            LinearLayout.HORIZONTAL, false)

}