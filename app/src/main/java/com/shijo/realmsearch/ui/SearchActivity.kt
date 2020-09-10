package com.shijo.realmsearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels

import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.flexbox.FlexboxLayout
import com.google.android.material.chip.Chip
import com.shijo.realmsearch.R
import com.shijo.realmsearch.adapter.SearchPagerAdapter
import com.shijo.realmsearch.databinding.ActivitySearchBinding
import com.shijo.realmsearch.viewmodel.SearchViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {

    private val viewModel : SearchViewmodel by viewModels()
    lateinit var binding : ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.viewmodel = viewModel
        initObservers()
        viewModel.searchData()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun initObservers() {
        viewModel.getSearchLivedata().observe(this, Observer {
            val pagerAdapter = SearchPagerAdapter(supportFragmentManager, it)
            binding.viewPager.adapter = pagerAdapter
        })
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