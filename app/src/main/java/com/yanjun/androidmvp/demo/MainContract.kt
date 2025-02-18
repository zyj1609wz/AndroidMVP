package com.yanjun.androidmvp.demo
import com.yanjun.androidmvp.demo.util.GithubRepo
import com.yanjun.androidmvp.mvp.contract.IViewContract
import retrofit2.Call

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:47 PM
 * @desc
 */
interface MainContract {

    interface IView : IViewContract {

        fun onFetchSuccess(list: List<GithubRepo>)

        fun onFetchFailed()
    }

    interface IPresenter {
        fun fetchData()
    }

    interface IModel{
        fun fetchData(): Call<List<GithubRepo>>
    }
}