package com.example.cleanarchmvvm.domain.repository

import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.model.LoginUserResponse
import com.example.cleanarchmvvm.data.repository.LoginRepository
import com.example.cleanarchmvvm.remote.LoginService
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 13/03/23.
 */
class LoginRepositoryImpl @Inject constructor(private val loginService: LoginService) :
    LoginRepository {

    override suspend fun doLogin(loginRequest: LoginUserRequest): LoginUserResponse {
        return loginService.doLogin(loginRequest)
    }
}