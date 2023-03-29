package com.example.cleanarchmvvm.di

import com.example.cleanarchmvvm.data.repository.LoginRepository
import com.example.cleanarchmvvm.domain.repository.LoginRepositoryImpl
import com.example.cleanarchmvvm.remote.LoginService
import com.example.cleanarchmvvm.remote.LoginServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Aalishan Ansari on 22/03/23.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {
    @Binds
    abstract fun bindLoginServiceInterface(loginServiceImpl: LoginServiceImpl): LoginService

    @Binds
    abstract fun bindLoginRepositoryInterface(loginRepositoryImpl: LoginRepositoryImpl): LoginRepository
}