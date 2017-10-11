package com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.populartracks

import com.example.riskteria.kotlinlistanko.di.scope.FragmentScope
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks.PopularTracksFragment
import dagger.Subcomponent

/**
 * Created by riskteria on 10/11/17.
 */

@FragmentScope
@Subcomponent(modules = arrayOf(
        PopularTracksFragmentModule::class
))
interface PopularTracksFragmentComponent {

    fun injectTo(fragment: PopularTracksFragment)

}