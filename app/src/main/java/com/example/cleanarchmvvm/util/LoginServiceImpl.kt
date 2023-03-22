package com.example.cleanarchmvvm.util

import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.model.LoginUserResponse
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 13/03/23.
 */
class LoginServiceImpl @Inject constructor() : LoginService {

    override fun doLogin(loginUser: LoginUserRequest): LoginUserResponse {

        if (loginUser.userName == "Aalishan" || loginUser.pwd == "12345") {
            return LoginUserResponse(200, "Successfully logged in")
        }
        return LoginUserResponse(501, "Something went wrong")
    }

}
