package com.yanjun.androidmvp.demo.fragment

import com.yanjun.androidmvp.demo.util.GithubRepo
import com.yanjun.androidmvp.demo.util.MainService
import com.yanjun.androidmvp.demo.util.RetrofitHolder
import com.yanjun.androidmvp.mvp.BaseMvpModel
import io.reactivex.rxjava3.core.Single

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:08 PM
 * @desc
 */
class MainFragmentModel : BaseMvpModel(), FragmentContract.IModel {

    private val service: MainService = RetrofitHolder.mRetrofit.create(MainService::class.java)

    override fun fetchData(): Single<List<GithubRepo>> {
        return service.listRepos("zyj1609wz")
    }
}