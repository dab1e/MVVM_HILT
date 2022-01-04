package com.example.mvvm_hilt.ui.common

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_hilt.ui.adapter.RecyclerUserAdapter
import com.example.mvvm_hilt.ui.fragment.NavOneFragment
import com.example.mvvm_hilt.ui.viewmodel.UserShow
import javax.inject.Inject

open class BindingAdapter {


    companion object {
        @JvmStatic
        @BindingAdapter("adapterUser")
        fun adapterUser(
            recyclerView: RecyclerView,
            listUser: ArrayList<UserShow>?
        ) {
            listUser?.let {
                val adapterUser = RecyclerUserAdapter(it)
                recyclerView.apply {
                    adapter = adapterUser
                }
            }

        }
    }
}