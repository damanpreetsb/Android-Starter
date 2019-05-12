package com.daman.starter.domain

import com.daman.starter.data.model.User
import com.daman.starter.data.repository.AppRepository
import io.reactivex.Single
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val repository: AppRepository
) {

    fun getUserList() : Single<List<User>> {
        return repository.getUserList()
    }
}
