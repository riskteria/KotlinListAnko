package com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks

import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.di.ApplicationComponent
import com.example.riskteria.kotlinlistanko.di.subcomponent.fragment.populartracks.PopularTracksFragmentModule
import com.example.riskteria.kotlinlistanko.repository.TrackRepository
import com.example.riskteria.kotlinlistanko.ui.adapter.TracksAdapter
import com.example.riskteria.kotlinlistanko.ui.fragment.BaseFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by riskteria on 10/9/17.
 */
class PopularTracksFragment : BaseFragment<PopularTracksLayout>() {

    private var ui: PopularTracksLayout? = null

    @Inject
    lateinit var adapter: TracksAdapter

    @Inject
    lateinit var repository: TrackRepository

    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadTracksData()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        ui = container?.let { PopularTracksLayout(container) }
        return ui?.inflate()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTracks()
        initLayoutManager()
    }

    override fun injectDependencies(applicationComponent: ApplicationComponent) {
        applicationComponent
                .inject(PopularTracksFragmentModule(this))
                .injectTo(this)
    }

    private fun loadTracksData() {
        repository.getTopTracks(1, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { tracks -> adapter.items = tracks }
    }

    private fun initTracks() {
        ui?.trackList?.adapter = adapter
    }

    private fun initLayoutManager() {
        ui?.trackList?.layoutManager = layoutManager
    }

}