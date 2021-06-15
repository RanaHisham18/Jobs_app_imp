package com.rana.jobs_app_imp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rana.jobs_app_imp.R
import com.rana.jobs_app_imp.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel



//home fragment which displays the jobs recyclerview and enable clicking on it.
class HomeFragment : Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModel()
    //enable the viewmodel
    private val adapter = JobsAdapter(::onJobClicked)
    //init the adapter and make it clickable.

    private fun onJobClicked(jobItem: JobItem) {
        // do whatever u need when the job item clicked
        Toast.makeText(requireContext(), jobItem.title, Toast.LENGTH_SHORT).show()
        //show the job details in a toast for short time.
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        viewModel.stateLiveData.observe(viewLifecycleOwner, { state ->
            renderState(state)
            //view the state of the list(loading, success, error)
            //using livedata
        })
    }

    private fun initViews() {
        binding.jobsRV.adapter = adapter
        //set the adapter cells to the jobs by view-binding method.
    }

    private fun renderState(state: HomeState) {
        //making a selection over the state of the fragment.

        when (state)  {
            is HomeState.Error -> showError(state.errorMessage)
            //show error message when the loading fails.
            HomeState.Loading -> showLoading()
            //show loadind when its loading.
            is HomeState.Success -> showSuccess(state)
            //show succes when it opens successfully.
        }
    }

    private fun showError(errorMessage: String) {
        // handle error state
    }

    private fun showLoading() {
        binding.loadingPb.visibility = View.VISIBLE
        //show loading state
        binding.jobsRV.visibility = View.GONE
        //hide loading state
    }

    private fun showSuccess(state: HomeState.Success) {
        adapter.submitList(state.jobsList)
        binding.loadingPb.visibility = View.GONE
        //show success state
        binding.jobsRV.visibility = View.VISIBLE
        //hide success state
    }
    // view binding ( till create ViewBindingDelegate )
    private var _binding: FragmentHomeBinding? = null
    //I have some cinflicts here :(
   private val binding get() = _binding!!
    //I have some cinflicts here :(

    override fun onCreateView(
        inflater: LayoutInflater,
        //initialize the layout views to the data items
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //destroy the view
        _binding = null
        //initialize null to the view binding
    }

}








