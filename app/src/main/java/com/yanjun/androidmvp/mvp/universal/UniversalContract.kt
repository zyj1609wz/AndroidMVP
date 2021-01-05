package com.yanjun.androidmvp.mvp.universal

import com.yanjun.androidmvp.mvp.contract.IViewContract

/**
 * @author yanjun.zhao
 * @time 2021/1/5 3:47 PM
 * @desc 通用Contract
 */
interface UniversalContract {

    interface IView : IViewContract

    interface IPresenter

    interface IModel
}