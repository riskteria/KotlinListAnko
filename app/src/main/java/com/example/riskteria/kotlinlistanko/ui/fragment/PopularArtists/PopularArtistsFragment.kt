package com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.di.ApplicationComponent
import com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.popularartists.PopularArtistsFragmentModule
import com.example.riskteria.kotlinlistanko.repository.ArtistRepository
import com.example.riskteria.kotlinlistanko.ui.adapter.ArtistsAdapter
import com.example.riskteria.kotlinlistanko.ui.fragment.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by riskteria on 10/7/17.
 */
class PopularArtistsFragment : BaseFragment<PopularArtistsLayout>() {

    private var ui: PopularArtistsLayout? = null

    @Inject
    lateinit var adapter: ArtistsAdapter

    @Inject
    lateinit var repository: ArtistRepository

    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadArtistsData()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        ui = container?.let { PopularArtistsLayout(container) }
        return ui?.inflate()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArtists()
        initLayoutManager()
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent
                .inject(PopularArtistsFragmentModule(this))
                .injectTo(this)
    }

    private fun loadArtistsData() {
        repository.getTopArtists(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { artists -> adapter.items = artists }
    }

    private fun initArtists() {
        ui?.artistList?.adapter = adapter
    }

    private fun initLayoutManager() {
        ui?.artistList?.layoutManager = layoutManager
    }

}