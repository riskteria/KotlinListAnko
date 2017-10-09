package com.example.riskteria.kotlinlistanko.ui.fragment.PopularArtists

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.riskteria.kotlinlistanko.repository.ArtistRepository
import com.example.riskteria.kotlinlistanko.ui.adapter.ArtistsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by riskteria on 10/7/17.
 */
class PopularArtistsFragment : Fragment() {

    private var ui: PopularArtistsLayout? = null

    private lateinit var adapter: ArtistsAdapter
    private lateinit var repository: ArtistRepository
    private lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRepository()
        initAdapter()
        loadArtistData()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = container?.let { PopularArtistsLayout(container) }
        return ui?.inflate()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        initArtists()
        initLayoutManager()
    }

    private fun initRepository() {
        repository = ArtistRepository()
    }

    private fun initAdapter() {
        adapter = ArtistsAdapter()
    }

    private fun loadArtistData() {
        repository.getTopArtists(1, 10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { artists -> adapter.items = artists }
    }

    private fun initArtists() {
        ui?.artistList?.adapter = adapter
    }

    private fun initLayoutManager() {
        layoutManager = GridLayoutManager(this.context, 2)
        ui?.artistList?.layoutManager = layoutManager
    }

}