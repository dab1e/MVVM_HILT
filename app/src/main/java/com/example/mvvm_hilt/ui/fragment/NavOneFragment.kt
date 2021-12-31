package com.example.mvvm_hilt.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_hilt.R
import com.example.mvvm_hilt.data.model.User
import com.example.mvvm_hilt.databinding.NavOneFragmentBinding
import com.example.mvvm_hilt.ui.adapter.RecyclerUserAdapter
import com.example.mvvm_hilt.ui.viewmodel.NavOneViewModel

class NavOneFragment : Fragment() {

    companion object {
        fun newInstance() = NavOneFragment()
    }

    private lateinit var viewModel: NavOneViewModel
    private lateinit var binding: NavOneFragmentBinding
    private lateinit var adapterUser: RecyclerUserAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NavOneFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NavOneViewModel::class.java)
        viewModel.getUser()
        viewModel.listUser.observe(viewLifecycleOwner,{
            adapterUser = RecyclerUserAdapter(it)
            binding.rcUser.apply {
                layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
                adapter = adapterUser
            }
        })
    }

}