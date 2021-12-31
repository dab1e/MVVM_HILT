package com.example.mvvm_hilt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_hilt.data.model.User
import com.example.mvvm_hilt.databinding.ItemUserBinding
import com.example.mvvm_hilt.ui.viewmodel.UserShow

class RecyclerUserAdapter(private val list: ArrayList<UserShow>): RecyclerView.Adapter<RecyclerUserAdapter.UserViewHolder>() {
    inner class UserViewHolder (val binding: ItemUserBinding ) :RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            val user = list.get(position)
            binding.userName.text = user.user
            binding.fullName.text = user.fullName
            binding.userAge.text = user.age
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerUserAdapter.UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater,parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerUserAdapter.UserViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = list.size
}