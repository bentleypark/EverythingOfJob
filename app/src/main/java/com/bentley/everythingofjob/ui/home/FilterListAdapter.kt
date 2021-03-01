package com.bentley.everythingofjob.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bentley.common.ex.makeGone
import com.bentley.common.ex.makeVisible
import com.bentley.everythingofjob.R
import com.bentley.everythingofjob.databinding.ItemFilterListBinding

class FilterListAdapter(private val list: MutableList<FilterItem>) : RecyclerView.Adapter<FilterListAdapter.FilterListViewHolder>() {

    private lateinit var binding: ItemFilterListBinding

    inner class FilterListViewHolder(private val binding: ItemFilterListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: FilterItem) {
            binding.tvTitle.text = item.title
            if (item.isSelected) {
                binding.tvTitle.apply {
                    setTextColor(context.resources.getColor(R.color.teal_700, null))
                }
            } else {
                binding.tvTitle.apply {
                    setTextColor(context.resources.getColor(R.color.gray, null))
                }
            }

//            binding.filterItem.isSelected = item.isSelected

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemFilterListBinding.inflate(layoutInflater)
        return FilterListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilterListViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size

}

data class FilterItem(val title: String, val isSelected: Boolean = false)