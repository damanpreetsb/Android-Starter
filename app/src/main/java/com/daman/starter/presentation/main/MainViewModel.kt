package com.daman.starter.presentation.main

import androidx.lifecycle.MutableLiveData
import com.daman.starter.core.vo.Resource
import com.daman.starter.core.vo.Resource.*
import com.daman.starter.data.model.User
import com.daman.starter.domain.MainUseCase
import com.daman.starter.presentation.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainUseCase: MainUseCase
): BaseViewModel() {

    val userList = MutableLiveData<Resource<List<User>>>()

    fun getUserList() {
        userList.value = Loading()
        mainUseCase.getUserList()
            .subscribe({
                userList.value = Success(it)
            }, {
                userList.value = Failure(it)
            })
            .addTo(disposable)
    }
}