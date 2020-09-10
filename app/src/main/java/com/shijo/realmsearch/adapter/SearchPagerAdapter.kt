package com.shijo.realmsearch.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shijo.realmsearch.models.Results
import com.shijo.realmsearch.ui.fragments.ResultFragment

class SearchPagerAdapter(
    fragmentManager: FragmentManager,
    private val results: List<Results>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return ResultFragment.newInstance(position, "")
    }

    override fun getCount(): Int {
        return results.size + 1
    }

    // Returns the page title for the top indicator
    override fun getPageTitle(position: Int): CharSequence? {
        return if(position == 0) {
            "All"
        } else {
            results[position-1].block_name
        }
    }
}