package com.daman.starter.presentation.main

import android.text.TextUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.daman.starter.R
import com.daman.starter.injection.factory.DaggerViewModelFactory
import com.daman.starter.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {

    @Inject
    lateinit var mViewModelFactory: DaggerViewModelFactory

    override fun getLayoutRes(): Int = R.layout.activity_main

    override fun initViewModel(): MainViewModel = ViewModelProviders.of(
        this,
        mViewModelFactory
    ).get(MainViewModel::class.java)

    override fun initView() {
        viewModel.getUserList()
    }

    override fun handlerViewModel() {
        viewModel.userList.observe(this, Observer {
            val string = TextUtils.join("," , it)
            textView.text = string
        })
    }
}
