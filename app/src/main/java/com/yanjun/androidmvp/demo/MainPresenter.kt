package com.yanjun.androidmvp.demo

import com.yanjun.androidmvp.mvp.BaseMvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author yanjun.zhao
 * @time 2021/1/5 2:41 PM
 * @desc
 */
class MainPresenter : BaseMvpPresenter<MainContract.IView, MainModel>(), MainContract.IPresenter {

    override fun registerModel(): Class<MainModel> {
        return MainModel::class.java
    }

    override fun fetchData() {
        getModel().fetchData()
            .enqueue(object : Callback<List<GithubRepo>> {
                override fun onResponse(
                    call: Call<List<GithubRepo>>,
                    response: Response<List<GithubRepo>>
                ) {
                    response.body()?.let {
                        getView().onFetchSuccess(it)
                    }

                }

                override fun onFailure(call: Call<List<GithubRepo>>, t: Throwable) {
                    getView().onFetchFailed()
                }
            })
    }
}