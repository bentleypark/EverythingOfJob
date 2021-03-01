package com.bentley.everythingofjob.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.bentley.common.base.BaseFragment
import com.bentley.common.ex.runLayoutAnimation
import com.bentley.everythingofjob.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val listAdapter: JobSiteListAdapter by lazy {
        JobSiteListAdapter(JobSiteList.fetchJobSiteData().toMutableList())
    }
    private val filterBottomSheetFragment = FilterBottomSheetFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun setUpObserve(viewLifecycleOwner: LifecycleOwner) {
        homeViewModel.apply {

            text.observe(viewLifecycleOwner, {

            })
        }
    }

    override fun setupView() {
        binding.apply {

            rvJobSiteList.apply {
                adapter = listAdapter
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                runLayoutAnimation()
            }


            btnFilter.setOnClickListener {
                parentFragment?.let { it -> filterBottomSheetFragment.show(it.requireFragmentManager(),"") }
            }
        }
    }
}