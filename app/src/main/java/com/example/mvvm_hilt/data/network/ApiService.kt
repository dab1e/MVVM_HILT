package com.example.mvvm_hilt.data.network

import com.example.mvvm_hilt.data.model.User
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET(ApiUrl.GET_USER)
    fun getUser(): Observable<List<User>>
}