package com.daman.starter.domain

import com.daman.starter.data.model.User
import com.daman.starter.data.repository.MainRepository
import io.reactivex.Single
import javax.inject.Inject

class MainUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    fun getUserList() : Single<ArrayList<User>> {
        return mainRepository.getUserList()
    }
}