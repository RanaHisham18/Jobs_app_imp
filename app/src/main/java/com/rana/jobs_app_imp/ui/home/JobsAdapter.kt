package com.rana.jobs_app_imp.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rana.jobs_app_imp.databinding.JobItemLayoutBinding
import kotlinx.coroutines.Job
import kotlin.reflect.KFunction1


class JobsAdapter(
    private val onJobItemClicked: (JobItem) -> Unit,
) : ListAdapter<JobItem, JobsAdapter.ViewHolder>(
    DiffCallback()
) {

    class ViewHolder(
        private val binding: JobItemLayoutBinding,
        private val onJobClicked: (job: JobItem) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(job: JobItem) = with(binding) {

            root.setOnClickListener { onJobClicked(job) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}


class DiffCallback : DiffUtil.ItemCallback<JobItem>() {

    override fun areItemsTheSame(
        oldItem: JobItem,
        newItem: JobItem,
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: JobItem,
        newItem: JobItem,
    ): Boolean {
        return oldItem == newItem
    }
}