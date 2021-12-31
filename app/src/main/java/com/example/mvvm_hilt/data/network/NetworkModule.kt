package com.example.mvvm_hilt.data.network

import com.example.mvvm_hilt.data.network.ApiUrl.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkModule {

    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(callAdapter())
        .client(provideOkhttp(provideOkhttpInterceptor()))
        .build()
    private fun callAdapter() = RxJava3CallAdapterFactory.create()

    private fun provideOkhttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    private fun provideOkhttpInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    fun providerApiServer(): ApiService = retrofitBuilder.create(ApiService::class.java)

}