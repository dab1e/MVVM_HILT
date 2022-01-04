package com.example.mvvm_hilt.data.repo

import com.example.mvvm_hilt.data.model.User
import com.example.mvvm_hilt.data.network.ApiHelper
import com.example.mvvm_hilt.data.network.ApiHelperImpl
import com.example.mvvm_hilt.data.network.NetworkModule
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RepositoryApp @Inject constructor(private val apiHelper: ApiHelperImpl){
    fun getUserRepo() = apiHelper.getUser()

}