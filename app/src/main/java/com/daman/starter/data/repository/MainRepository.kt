package com.daman.starter.data.repository

import com.daman.starter.core.schedulers.applyIoScheduler
import com.daman.starter.data.api.ApiInterface
import com.daman.starter.data.model.User
import io.reactivex.Single
import javax.inject.Inject

class MainRepository @Inject constructor(
    /**
     * uncomment below statement if you want
     * to fetch data from api
     */
//    val apiInterface: ApiInterface
){

    fun getUserList() : Single<ArrayList<User>> {
        val userList = arrayListOf(
            User(1, "User1"),
            User(2, "User2"),
            User(3, "User3"),
            User(4, "User4"),
            User(5, "User5")
        )
        return Single.just(userList).applyIoScheduler()
    }

}