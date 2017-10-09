package com.example.riskteria.kotlinlistanko.ui.fragment.PopularTracks

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.repository.TrackRepository
import com.example.riskteria.kotlinlistanko.ui.adapter.TrackAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by riskteria on 10/9/17.
 */
class PopularTracksFragment : Fragment() {

    private var ui: PopularTracksLayout? = null

    private lateinit var adapter: TrackAdapter
    private lateinit var repository: TrackRepository
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRepository()
        initAdapter()
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

    private fun initRepository() {
        repository = TrackRepository()
    }

    private fun initAdapter() {
        adapter = TrackAdapter()
    }

    private fun loadTracksData() {
        repository.getTopTracks(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { tracks -> adapter.items = tracks }
    }

    private fun initTracks() {
        ui?.trackList?.adapter = adapter
    }

    private fun initLayoutManager() {
        layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        ui?.trackList?.layoutManager = layoutManager
    }

}