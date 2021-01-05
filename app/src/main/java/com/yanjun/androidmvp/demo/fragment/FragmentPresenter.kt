package com.yanjun.androidmvp.demo.fragment

import com.yanjun.androidmvp.demo.util.RxUtils
import com.yanjun.androidmvp.mvp.BaseMvpPresenter

/**
 * @author yanjun.zhao
 * @time 2021/1/5 2:41 PM
 * @desc
 */
class FragmentPresenter : BaseMvpPresenter<MainFragment, MainFragmentModel>(),
    FragmentContract.IPresenter {

    override fun registerModel(): Class<MainFragmentModel> {
        return MainFragmentModel::class.java
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