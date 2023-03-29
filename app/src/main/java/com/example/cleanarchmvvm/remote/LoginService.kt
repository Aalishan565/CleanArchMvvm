package com.example.cleanarchmvvm.remote

import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.model.LoginUserResponse

/**
 * Created by Aalishan Ansari on 13/03/23.
 */
interface LoginService {
    fun doLogin(loginUser: LoginUserRequest): LoginUserResponse
}
