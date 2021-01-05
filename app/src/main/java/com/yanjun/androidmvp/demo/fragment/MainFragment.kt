package com.yanjun.androidmvp.demo.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.yanjun.androidmvp.R
import com.yanjun.androidmvp.demo.util.GithubRepo
import com.yanjun.androidmvp.mvp.BaseMvpFragment

class MainFragment : BaseMvpFragment<FragmentPresenter>(), FragmentContract.IView {
    private var param1: String? = null

    private var tv: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_main
    }

    override fun registerPresenter(): Class<FragmentPresenter> {
        return FragmentPresenter::class.java
    }

    override fun initView(view: View) {
        super.initView(view)
        tv = findViewById(R.id.tv)
    }

    override fun initData() {
        super.initData()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }

        getPresenter().fetchData()
    }

    companion object {

        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
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
        tv?.text = "loading....参数:$param1"
    }

}