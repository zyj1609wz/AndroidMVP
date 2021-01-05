package com.yanjun.androidmvp.mvp

import com.yanjun.androidmvp.mvp.contract.IModelContract
import com.yanjun.androidmvp.mvp.contract.IPresenterContract
import com.yanjun.androidmvp.mvp.contract.IViewContract

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:00 PM
 * @desc
 */
abstract class BaseMvpPresenter<V : IViewContract, M : IModelContract> : IPresenterContract {

    private lateinit var mView: V
    private lateinit var mModel: M

    abstract fun registerModel(): Class<M>

    fun getModel(): M {
        return mModel
    }

    fun getView(): V {
        return mView
    }

    override fun onCreate() {
        mModel = registerModel().newInstance()
        mModel.onCreate()
    }

    override fun registerView(mvpView: IViewContract) {
        mView = mvpView as V
    }

    override fun onStart() {

    }

    override fun onResume() {

    }

    override fun onPause() {

    }

    override fun onStop() {
    }

    override fun onDestroy() {
        mModel.onDestroy()
    }
}