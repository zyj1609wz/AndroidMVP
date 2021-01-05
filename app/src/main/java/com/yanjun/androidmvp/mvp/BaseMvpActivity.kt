package com.yanjun.androidmvp.mvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yanjun.androidmvp.mvp.contract.IPresenterContract
import com.yanjun.androidmvp.mvp.contract.IViewContract

abstract class BaseMvpActivity<P : IPresenterContract> : AppCompatActivity(), IViewContract {

    private lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = registerPresenter().newInstance()
        mPresenter.onCreate()
        mPresenter.registerView(this)
        setContentView(getLayoutId())
        initView()
        initData()
    }

    protected abstract fun getLayoutId(): Int

    fun getPresenter(): P {
        return mPresenter
    }

    abstract fun registerPresenter(): Class<P>

    abstract fun initView()
    abstract fun initData()

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun showLoading() {
    }

    override fun showError(errMes: String) {

    }

    override fun dismissLoading() {
    }
}