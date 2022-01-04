package com.example.mvvm_hilt.data.network

import com.example.mvvm_hilt.data.model.User
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper{

    override fun getUser(): Observable<List<User>> = apiService.getUser()

}