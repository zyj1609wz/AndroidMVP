package com.yanjun.androidmvp.demo.fragment

import com.yanjun.androidmvp.demo.util.GithubRepo
import com.yanjun.androidmvp.mvp.BaseMvpPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author yanjun.zhao
 * @time 2021/1/5 2:41 PM
 * @desc
 */
class FragmentPresenter : BaseMvpPresenter<MainFragment, MainFragmentModel>(), FragmentContract.IPresenter {

    override fun registerModel(): Class<MainFragmentModel> {
        return MainFragmentModel::class.java
    }

    override fun fetchData() {
        getView().showLoading()

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