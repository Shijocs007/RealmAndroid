package com.shijo.realmsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import com.shijo.realmsearch.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

    }

    private fun addNewChip(person: String, chipGroup: FlexboxLayout) {
        val chip = Chip(this)
        chip.text = person
        chip.chipIcon = ContextCompat.getDrawable(this, R.mipmap.ic_launcher_round)
        chip.isCloseIconEnabled = true
        chip.isClickable = true
        chip.isCheckable = false
        chipGroup.addView(chip as View, chipGroup.childCount - 1)
        chip.setOnCloseIconClickListener { chipGroup.removeView(chip as View) }
    }
}