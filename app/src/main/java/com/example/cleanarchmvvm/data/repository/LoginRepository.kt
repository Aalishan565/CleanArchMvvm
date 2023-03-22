package com.example.cleanarchmvvm.data.repository

import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.model.LoginUserResponse

/**
 * Created by Aalishan Ansari on 13/03/23.
 */
interface LoginRepository {
    fun doLogin(loginRequest: LoginUserRequest): LoginUserResponse
}