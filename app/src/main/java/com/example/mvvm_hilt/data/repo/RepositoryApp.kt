package com.example.mvvm_hilt.data.repo

import com.example.mvvm_hilt.data.model.User
import com.example.mvvm_hilt.data.network.NetworkModule
import io.reactivex.rxjava3.core.Observable

class RepositoryApp {
    private val network = NetworkModule()
    fun getUserRepo(): Observable<List<User>> {
        return network.providerApiServer().getUser()
    }
}