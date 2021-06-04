package com.rana.jobs_app_imp.ui.start


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rana.jobs_app_imp.R
import com.rana.jobs_app_imp.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startBtn.setOnClickListener {
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToHomeFragment()
            )
        }
    }


    // view binding ( till create ViewBindingDelegate )
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}