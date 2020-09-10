package com.shijo.realmsearch.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.shijo.realmsearch.R
import com.shijo.realmsearch.adapter.UnitAdapter
import com.shijo.realmsearch.databinding.FragmentResultBinding
import com.shijo.realmsearch.models.Results
import com.shijo.realmsearch.models.Units
import com.shijo.realmsearch.viewmodel.SearchViewmodel
import dagger.hilt.android.AndroidEntryPoint
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_result.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class ResultFragment : Fragment() {
    private var param1: Int = 0
    private var param2: String? = null

    private val viewModel : SearchViewmodel by activityViewModels()
    lateinit var binding : FragmentResultBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getInt(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentResultBinding>(inflater, R.layout.fragment_result, container, false)
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.getSearchLivedata().observe(viewLifecycleOwner, Observer {
            val adapter = it[param1].units?.let { it1 -> UnitAdapter(it1, context) }
            binding.rvParent.layoutManager = LinearLayoutManager(context)
            binding.rvParent.adapter = adapter
        })
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        @JvmStatic
        fun newInstance(param1: Int, param2: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}