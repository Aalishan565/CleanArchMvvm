package com.example.cleanarchmvvm.presentation.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchmvvm.R
import com.example.cleanarchmvvm.data.model.LoginUserRequest
import com.example.cleanarchmvvm.data.model.LoginUserResponse
import com.example.cleanarchmvvm.data.repository.LoginRepository
import com.example.cleanarchmvvm.utils.Resource
import com.example.cleanarchmvvm.utils.ValidationUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Aalishan Ansari on 22/03/23.
 */

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val application: Application,
    private val loginRepository: LoginRepository
) :
    AndroidViewModel(application) {

    private var _loginResult: MutableLiveData<Resource<LoginUserResponse>> = MutableLiveData()
    val loginResult: LiveData<Resource<LoginUserResponse>> get() = _loginResult

    fun validateInputAndDoLogin(userName: String, pwd: String, dispatcher: CoroutineDispatcher) {
        viewModelScope.launch(dispatcher) {
            if (!ValidationUtil.isValidInput(userName) && !ValidationUtil.isValidInput(pwd)) {
                _loginResult.postValue(Resource.Error(application.getString(R.string.please_enter_valid_input)))
            } else if (!ValidationUtil.isValidInput(userName)) {
                _loginResult.postValue(Resource.Error(application.getString(R.string.please_enter_valid_user_name)))
            } else if (!ValidationUtil.isValidInput(pwd)) {
                _loginResult.postValue(Resource.Error(application.getString(R.string.please_enter_valid_pwd)))
            } else {
                val loginReq = LoginUserRequest(userName = userName, pwd = pwd)
                doLogin(loginReq)
            }
        }
    }

    private suspend fun doLogin(loginReq: LoginUserRequest) {
        val result = loginRepository.doLogin(loginReq)
        if (result.responseCode == 200) {
            _loginResult.postValue(Resource.Success(result))
        } else {
            _loginResult.postValue(Resource.Error(result.message))
        }
    }

}