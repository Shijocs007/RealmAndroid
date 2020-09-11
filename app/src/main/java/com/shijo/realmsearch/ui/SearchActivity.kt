package com.shijo.realmsearch.ui

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
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

        binding.searchKey.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                addNewChip(binding.searchKey.text.toString(), binding.rsearchGroup)
                true
            }
            false
        }
    }


    private fun initObservers() {
        viewModel.getSearchLivedata().observe(this, Observer {
            val pagerAdapter = SearchPagerAdapter(supportFragmentManager, it)
            binding.viewPager.adapter = pagerAdapter
        })
    }

    private fun addNewChip(chipText: String, chipGroup: FlexboxLayout) {
        if(chipText == "")
            return
        val chip = Chip(this)
        chip.text = chipText
        chip.setCloseIconResource(R.drawable.close_button)
        chip.isCloseIconEnabled = true
        chip.isClickable = true
        chip.isCheckable = false
        chip.setTextColor(resources.getColor(R.color.realm_yellow))
        chip.chipBackgroundColor = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.recycler_item_bg)
        )
        chip.setBackgroundColor(resources.getColor(R.color.recycler_item_bg))
        chipGroup.addView(chip as View, chipGroup.childCount - 1)
        viewModel.searchData(chipText, true)
        binding.searchKey.setText("")
        chip.setOnCloseIconClickListener {
            chipGroup.removeView(chip as View)
            viewModel.searchData(chipText, false)
        }
    }
}