package com.yanjun.androidmvp.demo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:33 PM
 * @desc
 */
interface MainService {
    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user: String): Call<List<GithubRepo>>
}