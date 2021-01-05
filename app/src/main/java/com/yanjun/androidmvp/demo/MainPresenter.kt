package com.yanjun.androidmvp.demo

import com.yanjun.androidmvp.demo.util.RxUtils
import com.yanjun.androidmvp.mvp.BaseMvpPresenter

/**
 * @author yanjun.zhao
 * @time 2021/1/5 2:41 PM
 * @desc
 */
class MainPresenter : BaseMvpPresenter<MainActivity, MainModel>(), MainContract.IPresenter {

    override fun registerModel(): Class<MainModel> {
        return MainModel::class.java
    }

    override fun fetchData() {
        getView().showLoading()

        getModel().fetchData()
            .compose(RxUtils.singleToMain())
            .subscribe({
                getView().onFetchSuccess(it)
            }) {
                getView().onFetchFailed()
            }
    }
}