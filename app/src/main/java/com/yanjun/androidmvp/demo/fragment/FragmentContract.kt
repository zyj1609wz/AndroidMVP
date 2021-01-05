package com.yanjun.androidmvp.demo.fragment
import com.yanjun.androidmvp.demo.util.GithubRepo
import com.yanjun.androidmvp.mvp.contract.IViewContract
import io.reactivex.rxjava3.core.Single

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:47 PM
 * @desc
 */
interface FragmentContract {

    interface IView : IViewContract {

        fun onFetchSuccess(list: List<GithubRepo>)

        fun onFetchFailed()
    }

    interface IPresenter {
        fun fetchData()
    }

    interface IModel{
        fun fetchData(): Single<List<GithubRepo>>
    }
}