package com.example.mvvm_hilt.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm_hilt.databinding.LastFragmentBinding
import com.example.mvvm_hilt.ui.viewmodel.LastViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LastFragment : Fragment() {

    companion object {
        fun newInstance() = LastFragment()
    }

    private lateinit var viewModel: LastViewModel
    private lateinit var binding: LastFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LastFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LastViewModel::class.java)

    }

}