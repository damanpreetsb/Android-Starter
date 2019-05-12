package com.daman.starter.data.repository

import com.daman.starter.data.model.User
import io.reactivex.Single

interface AppRepository {
    fun getUserList() : Single<List<User>>
}
