package com.example.pricingpal.model.modules

import com.example.pricingpal.usecase.*
import com.example.pricingpal.usecase.impl.DeleteUserUseCaseImpl
import com.example.pricingpal.usecase.impl.GetUserUseCaseImpl
import com.example.pricingpal.usecase.impl.LoginUseCaseImpl
import com.example.pricingpal.usecase.impl.SignUpUseCaseImpl
import com.example.pricingpal.usecase.impl.UpdateUserUseCaseImpl
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

    /**
     * This function uses the @Binds annotation to bind an abstract GetUserUseCase
     * class its implementation, which informs Dagger Hilt to use GetUserUseCaseImpl
     * whenever an instance of GetUserUseCase is required.
     *
     * @author Shianne Lesure
     * @param impl reference to the GetUserUseCaseImpl
     */
    @Binds
    abstract fun bindGetUserUseCase(impl: GetUserUseCaseImpl): GetUserUseCase

    /**
     * This function uses the @Binds annotation to bind an abstract DeleteUserUseCase
     * class its implementation, which informs Dagger Hilt to use DeleteUserUseCaseImpl
     * whenever an instance of DeleteUserUseCase is required.
     *
     * @author Shianne Lesure
     * @param impl reference to the DeleteUserUseCaseImpl
     */
    @Binds
    abstract fun bindDeleteUserUseCase(impl: DeleteUserUseCaseImpl): DeleteUserUseCase

    /**
     * This function uses the @Binds annotation to bind an abstract UpdateUserUseCase
     * class its implementation, which informs Dagger Hilt to use UpdateUserUseCaseImpl
     * whenever an instance of UpdateUserUseCase is required.
     *
     * @author Shianne Lesure
     * @param impl reference to the UpdateUserUseCaseImpl
     */
    @Binds
    abstract fun bindUpdateUserUseCase(impl: UpdateUserUseCaseImpl): UpdateUserUseCase

}