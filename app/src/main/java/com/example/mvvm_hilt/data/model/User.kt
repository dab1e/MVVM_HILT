package com.example.mvvm_hilt.data.model

import com.google.gson.annotations.SerializedName

data class User(@SerializedName("user")var user:String,
                @SerializedName("age") var age:Int,
                @SerializedName("firstname") var firstname:String,
                @SerializedName("lastname") var lastname:String
)