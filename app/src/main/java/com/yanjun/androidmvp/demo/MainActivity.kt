package com.yanjun.androidmvp.demo

import android.widget.TextView
import com.yanjun.androidmvp.R
import com.yanjun.androidmvp.demo.fragment.MainFragment
import com.yanjun.androidmvp.demo.universal.UniversalFragment
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

        //添加fragment
        var beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.container, MainFragment.newInstance("我是一个值，哈哈"))
        beginTransaction.commitAllowingStateLoss()

        //添加fragment,精简Fragment
        var beginTransaction2 = supportFragmentManager.beginTransaction()
        beginTransaction2.replace(R.id.container2, UniversalFragment.newInstance("我是一个值，哈哈"))
        beginTransaction2.commitAllowingStateLoss()
    }

    override fun onFetchFailed() {
        tv?.text = "failed"
    }

    override fun showLoading() {
        super.showLoading()
        tv?.text = "loading...."
    }

}