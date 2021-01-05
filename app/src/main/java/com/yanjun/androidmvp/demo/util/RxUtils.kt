package com.yanjun.androidmvp.demo.util

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.ObservableTransformer
import io.reactivex.rxjava3.core.SingleTransformer
import io.reactivex.rxjava3.schedulers.Schedulers


/**
 * There is a lot of misery in life
 **/
object RxUtils {

    /**
     * rx 线程调度
     *  io -> android.main
     * */
    fun <T> schedulerIO2Main(): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * 线程切换
     */
    fun <T> singleToMain(): SingleTransformer<T, T> {

        return SingleTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }

}