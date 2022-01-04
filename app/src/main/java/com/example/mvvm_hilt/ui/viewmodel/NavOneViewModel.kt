package com.example.mvvm_hilt.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_hilt.data.model.User
import com.example.mvvm_hilt.data.repo.RepositoryApp
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NavOneViewModel @Inject constructor(private val repo: RepositoryApp): ViewModel() {
    var listUser = MutableLiveData<ArrayList<UserShow>>()
    fun getUser(){
        repo.getUserRepo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).map {
                var listUser = ArrayList<UserShow>()
                it.forEach {
                    listUser.add(UserShow(user = "Name: ${it.user}",fullName= "Full Name: ${it.firstname} ${it.lastname}" , age = "Age: ${it.age}"))
                }
                return@map listUser
            }
            .subscribe (
                {
                    listUser.postValue(it)
                },{
                    Log.e("ERROR_GET_USER", it.toString())
                }
            )
    }
}

data class UserShow(val user: String, val fullName: String, val age: String)