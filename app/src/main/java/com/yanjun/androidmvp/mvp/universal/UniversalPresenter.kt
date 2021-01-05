package com.yanjun.androidmvp.mvp.universal

import com.yanjun.androidmvp.mvp.BaseMvpPresenter

/**
 * @author yanjun.zhao
 * @time 2021/1/5 2:41 PM
 * @desc 通用Presenter
 */
class UniversalPresenter : BaseMvpPresenter<UniversalContract.IView, UniversalModel>(), UniversalContract.IPresenter {

    override fun registerModel(): Class<UniversalModel> {
        return UniversalModel::class.java
    }
}