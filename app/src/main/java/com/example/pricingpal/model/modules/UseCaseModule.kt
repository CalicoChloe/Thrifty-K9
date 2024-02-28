package com.example.pricingpal.model.modules

import com.example.pricingpal.usecase.*
import com.example.pricingpal.usecase.impl.GetUserUseCaseImpl
import com.example.pricingpal.usecase.impl.LoginUseCaseImpl
import com.example.pricingpal.usecase.impl.SignUpUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    @Binds
    abstract fun bindAuthenticateUseCase(impl: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindSignUpUseCase(impl: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    abstract fun bindGetUserUseCase(impl: GetUserUseCaseImpl): GetUserUseCase

}