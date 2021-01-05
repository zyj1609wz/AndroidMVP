package com.yanjun.androidmvp.demo.httputil

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:21 PM
 * @desc
 */
object RetrofitHolder {

    var mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

}