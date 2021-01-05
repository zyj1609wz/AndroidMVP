package com.yanjun.androidmvp.mvp.contract

/**
 * View层公共契约接口
 **/
interface IViewContract {

    /**
     * 显示错误信息
     * @param errMes
     */
    fun showError(errMes: String)

    /**
     * 显示loading
     */
    fun showLoading()

    /**
     * 隐藏loading
     */
    fun dismissLoading()
}