package com.example.mvvm_hilt.data.network

import com.example.mvvm_hilt.data.model.User
import io.reactivex.rxjava3.core.Observable

interface ApiHelper {
    fun getUser(): Observable<List<User>>
}