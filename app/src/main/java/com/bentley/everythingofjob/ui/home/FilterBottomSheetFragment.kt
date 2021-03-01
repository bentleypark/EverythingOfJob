package com.bentley.everythingofjob.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bentley.everythingofjob.databinding.FilterBottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FilterBottomsheetBinding
    private lateinit var filterListAdapter: FilterListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FilterBottomsheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onSetupView()
    }

    private fun onSetupView() {
        filterListAdapter = FilterListAdapter(mutableListOf(FilterItem("전체", true), FilterItem("채용포탈"), FilterItem("스타트업"), FilterItem("IT"), FilterItem("의료"),
                FilterItem("학원강사"), FilterItem("미용"), FilterItem("방송"), FilterItem("알바"), FilterItem("프리랜서")))
        binding.apply {
            rvFilterList.apply {
                setHasFixedSize(true)
                addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
                adapter = filterListAdapter
            }

            btnClose.setOnClickListener {
                dismiss()
            }
        }
    }
}