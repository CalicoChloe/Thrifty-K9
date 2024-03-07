package com.example.pricingpal.model.modules

import com.example.pricingpal.usecase.*
import com.example.pricingpal.usecase.impl.LoginUseCaseImpl
import com.example.pricingpal.usecase.impl.SignUpUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Class: UseCaseModule
 * @author Chloe Jackson
 * @author Abdoulie NJie
 * This class creates a Dagger Hilt module that provides Dagger Hilt with information
 * on how to bind abstract classes to their corresponding implementations.
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

    /**
     * This function uses the @Binds annotation to bind an abstract LoginUseCase
     * class its implementation, which informs Dagger Hilt to use LoginUseCaseImpl
     * whenever an instance of LoginUseCase is required.
     *
     * @author Chloe Jackson
     * @param impl reference to the LoginUseCaseImpl
     *
     *
     */

    @Binds
    abstract fun bindAuthenticateUseCase(impl: LoginUseCaseImpl): LoginUseCase

    /**
     * This function uses the @Binds annotation to bind an abstract SignUpUseCase
     * class its implementation, which informs Dagger Hilt to use SignUpUseCaseImpl
     * whenever an instance of SignUpUseCase is required.
     *
     * @author Abdoulie NJie
     * @param impl reference to the SignUpUseCaseImpl
     *
     *
     */
    @Binds
    abstract fun bindSignUpUseCase(impl: SignUpUseCaseImpl): SignUpUseCase

}