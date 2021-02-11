package com.bentley.everythingofjob.ui.home

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bentley.data.model.JobSiteItem
import com.bentley.everythingofjob.databinding.ItemJobSiteListBinding

class JobSiteListAdapter(private val list: MutableList<JobSiteItem>) :
    RecyclerView.Adapter<JobSiteListAdapter.JobSiteListViewHolder>() {

    private lateinit var binding: ItemJobSiteListBinding

    inner class JobSiteListViewHolder(private val binding: ItemJobSiteListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: JobSiteItem) {
            binding.apply {
                tvTitle.text = item.title
                tvTags.text = item.tags
                ivLogo.load(item.image)
                btnFavorite.setOnClickListener {

                }
                jobSiteItem.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(item.url)
                    it.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobSiteListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding = ItemJobSiteListBinding.inflate(layoutInflater)
        return JobSiteListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JobSiteListViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() = list.size

    fun addAll(data: List<JobSiteItem>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}