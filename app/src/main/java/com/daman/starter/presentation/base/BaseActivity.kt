package com.daman.starter.presentation.base

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.daman.starter.R
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    val disposable = CompositeDisposable()
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        setContentView(R.layout.activity_base)
        viewStub.layoutResource = getLayoutRes()
        viewStub.inflate()
        hideLoading()
        viewModel = initViewModel()
        initView()
        handlerViewModel()
    }

    /**
     * override dagger inject activity
     */
    open fun inject() {
        AndroidInjection.inject(this)
    }

    /**
     * override layout
     */
    @LayoutRes
    abstract fun getLayoutRes(): Int

    /**
     * override viewmodel
     */
    abstract fun initViewModel() : VM

    /**
     * override view
     */
    abstract fun initView()

    /**
     * override viewmodel handler
     */
    abstract fun handlerViewModel()

    fun showLoading() {
        loadingLayout.visibility = VISIBLE
    }

    fun hideLoading() {
        loadingLayout.visibility = GONE
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}