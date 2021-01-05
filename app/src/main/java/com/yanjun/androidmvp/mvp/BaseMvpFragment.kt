package com.yanjun.androidmvp.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yanjun.androidmvp.mvp.contract.IPresenterContract
import com.yanjun.androidmvp.mvp.contract.IViewContract


abstract class BaseMvpFragment<P : IPresenterContract> : Fragment(), IViewContract {

    private lateinit var mPresenter: P
    private var layout: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = registerPresenter().newInstance()
        mPresenter.onCreate()
        mPresenter.registerView(this)
        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        layout = inflater.inflate(getLayoutId(), container, false)
        return layout
    }

    fun getPresenter(): P {
        return mPresenter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

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

    protected abstract fun getLayoutId(): Int

    abstract fun registerPresenter(): Class<P>

    /**
     * 初始化布局
     */
    open fun initView(view: View) {}

    /**
     * 初始化数据
     */
    protected open fun initData() {}

    /**
     * 通过findViewById获取初始化view的
     */
    protected fun <T : View> findViewById(id: Int): T? {
        return layout?.findViewById<T>(id)
    }

    override fun showError(errMes: String) {
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }
}