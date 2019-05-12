package com.daman.starter.presentation.main

import androidx.lifecycle.MutableLiveData
import com.daman.starter.data.model.User
import com.daman.starter.domain.MainUseCase
import com.daman.starter.presentation.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
): BaseViewModel() {

    val userList = MutableLiveData<List<User>>()

    fun getUserList() {
        mainUseCase.getUserList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { userList.value = it },
                { it.printStackTrace() }
            )
            .addTo(disposable)
    }
}
