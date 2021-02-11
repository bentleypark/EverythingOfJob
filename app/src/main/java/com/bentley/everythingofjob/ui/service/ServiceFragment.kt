package com.bentley.everythingofjob.ui.service

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.bentley.common.base.BaseFragment
import com.bentley.common.ex.runLayoutAnimation
import com.bentley.everythingofjob.databinding.FragmentServiceBinding
import com.bentley.everythingofjob.ui.home.JobSiteList
import com.bentley.everythingofjob.ui.home.JobSiteListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServiceFragment : BaseFragment<FragmentServiceBinding>() {

    private val listAdapter: JobSiteListAdapter by lazy {
        JobSiteListAdapter(JobSiteList.fetchServiceData().toMutableList())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentServiceBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun setUpObserve(viewLifecycleOwner: LifecycleOwner) {
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
        }
    }
}