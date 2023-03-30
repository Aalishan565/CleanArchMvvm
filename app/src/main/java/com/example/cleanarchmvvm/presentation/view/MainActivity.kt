package com.example.cleanarchmvvm.presentation.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.cleanarchmvvm.databinding.ActivityMainBinding
import com.example.cleanarchmvvm.presentation.view_model.LoginViewModel
import com.example.cleanarchmvvm.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _mainActivity: ActivityMainBinding? = null
    private val mainActivityBinding get() = _mainActivity!!

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_mainActivity!!.root)
        initViews()
        initObserver()
    }

    private fun initObserver() {
        loginViewModel.loginResult.observe(this) { response ->
            when (response) {
                is Resource.Loading -> {
                    showProgressBar()
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.message?.let {
                        showToast(it)
                    }
                }
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.message?.let {
                        showToast(it)
                    }
                }
            }

        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun hideProgressBar() {
        mainActivityBinding.progressBar.visibility = View.GONE
    }

    private fun showProgressBar() {
        mainActivityBinding.progressBar.visibility = View.VISIBLE
    }

    private fun initViews() {
        mainActivityBinding.btnLogin.setOnClickListener {
            val userName = mainActivityBinding.etUserName.text.toString()
            val pwd = mainActivityBinding.etPwd.text.toString()
            loginViewModel.validateInputAndDoLogin(userName, pwd, Dispatchers.IO)
        }
    }

    override fun onPause() {
        super.onPause()
        _mainActivity = null
    }

    override fun onStop() {
        super.onStop()
        _mainActivity = null
    }

}