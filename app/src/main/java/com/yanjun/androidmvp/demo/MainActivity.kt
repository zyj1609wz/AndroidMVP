package com.yanjun.androidmvp.demo

import android.widget.TextView
import com.yanjun.androidmvp.R
import com.yanjun.androidmvp.demo.util.GithubRepo
import com.yanjun.androidmvp.mvp.BaseMvpActivity

class MainActivity : BaseMvpActivity<MainPresenter>(), MainContract.IView {

    private var tv: TextView? = null

    override fun registerPresenter(): Class<MainPresenter> {
        return MainPresenter::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        tv = findViewById(R.id.tv)
    }

    override fun initData() {
        //请求网络
        getPresenter().fetchData()
    }

    override fun onFetchSuccess(list: List<GithubRepo>) {
        var bean = list[0]
        tv?.text = "id:${bean.id} name:${bean.name}"
    }

    override fun onFetchFailed() {
        tv?.text = "failed"
    }

    override fun showLoading() {
        super.showLoading()
        tv?.text = "loading...."
    }

}