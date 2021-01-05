package com.yanjun.androidmvp.demo.universal

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.yanjun.androidmvp.R
import com.yanjun.androidmvp.mvp.BaseMvpFragment
import com.yanjun.androidmvp.mvp.universal.UniversalPresenter

/**\
 * 精简Fragment写法，Activity类似
 */
class UniversalFragment : BaseMvpFragment<UniversalPresenter>() {
    private var param1: String? = null

    private var tv: TextView? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_universal
    }

    override fun registerPresenter(): Class<UniversalPresenter> {
        return UniversalPresenter::class.java
    }

    override fun initView(view: View) {
        super.initView(view)
        tv = findViewById(R.id.tv)

        tv?.text = "参数：$param1"
    }

    override fun initData() {
        super.initData()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    companion object {

        private const val ARG_PARAM1 = "param1"

        @JvmStatic
        fun newInstance(param1: String) =
            UniversalFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}