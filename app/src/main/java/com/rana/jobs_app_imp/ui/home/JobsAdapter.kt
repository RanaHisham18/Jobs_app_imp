package com.rana.jobs_app_imp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rana.jobs_app_imp.R
import com.rana.jobs_app_imp.databinding.JobItemLayoutBinding
import kotlinx.coroutines.Job


class JobsAdapter(
    private val onJobClicked: (job: JobItem) -> Unit
) : ListAdapter<JobItem, JobsAdapter.ViewHolder>(
    DiffCallback()
) {

    class ViewHolder(
        private val binding: JobItemLayoutBinding,
        private val onJobClicked: (job: JobItem) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(job: JobItem) = with(binding) {
            companyNameTv.text = job.companyName
            jobTitleTv.text = job.title
            jobTypeTv.text = job.type ?: ""
            companyLogoIv.load(job.companyLogo) {
                placeholder(R.drawable.appimage)
                fallback(R.drawable.appimage)
            }
            root.setOnClickListener { onJobClicked(job) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = JobItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding, onJobClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<JobItem>() {

    override fun areItemsTheSame(oldItem: JobItem, newItem: JobItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: JobItem, newItem: JobItem): Boolean {
        return oldItem == newItem
    }
}
