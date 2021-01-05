package com.yanjun.androidmvp.demo.universal

import android.widget.TextView
import com.yanjun.androidmvp.R
import com.yanjun.androidmvp.mvp.BaseMvpActivity
import com.yanjun.androidmvp.mvp.universal.UniversalPresenter

/**\
 * 精简Activity写法，Fragment类似
 */
class UniversalActivity : BaseMvpActivity<UniversalPresenter>() {

    private var param1: String? = null

    private var tv: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_universal
    }

    override fun registerPresenter(): Class<UniversalPresenter> {
        return UniversalPresenter::class.java
    }

    override fun initView() {
        tv = findViewById(R.id.tv)
        tv?.text = "参数：$param1"
    }

    override fun initData() {
    }
}