package com.example.cleanarchmvvm.domain.use_case

import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.model.LoginUserResponse
import com.example.cleanarchmvvm.data.repository.LoginRepository
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 29/03/23.
 */
class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {

    suspend operator fun invoke(loginUserRequest: LoginUserRequest): LoginUserResponse {
        return loginRepository.doLogin(loginUserRequest)
    }
}