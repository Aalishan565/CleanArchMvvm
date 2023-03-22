package com.example.cleanarchmvvm.presentation.view_model

import androidx.lifecycle.ViewModel
import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 22/03/23.
 */

@HiltViewModel
class LoginViewModel @Inject constructor(val loginRepository: LoginRepository) : ViewModel() {

    fun doLogin(userName: String, pwd: String) {
        val loginReq = LoginUserRequest(userName = userName, pwd = pwd)
        loginRepository.doLogin(loginReq)

    }

}