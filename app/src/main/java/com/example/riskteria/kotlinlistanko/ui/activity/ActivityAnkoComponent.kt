package com.example.riskteria.kotlinlistanko.ui.activity

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import org.jetbrains.anko.AnkoComponent

/**
 * Created by riskteria on 9/18/17.
 */

interface ActivityAnkoComponent<T: AppCompatActivity> : AnkoComponent<T> {
    val toolbar: Toolbar
}