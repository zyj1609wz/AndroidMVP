package com.yanjun.androidmvp.mvp.contract

/**
 * @author yanjun.zhao
 * @time 2021/1/5 2:25 PM
 * @desc
 */
interface IPresenterContract {

    fun onCreate()

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()

    fun registerView(mvpView: IViewContract)
}