package com.daman.starter.data.repository

import com.daman.starter.data.api.ApiInterface
import com.daman.starter.data.model.User
import io.reactivex.Single

class MainRepository (
    private val apiInterface: ApiInterface
) : AppRepository {
    override fun getUserList() : Single<List<User>> {
        val userList = arrayListOf(User(1, "User1"))

        return Single.just(userList)
    }
}
