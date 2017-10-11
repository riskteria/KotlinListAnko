package com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.popularartists

import com.example.riskteria.kotlinlistanko.di.scope.FragmentScope
import com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists.PopularArtistsFragment
import dagger.Subcomponent

/**
 * Created by riskteria on 10/11/17.
 */

@FragmentScope
@Subcomponent(modules = arrayOf(
        PopularArtistsFragmentModule::class
))
interface PopularArtistsFragmentComponent {

    fun injectTo(fragment: PopularArtistsFragment)

}