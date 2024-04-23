package com.example.pricingpal.model.modules

import com.example.pricingpal.usecase.*
import com.example.pricingpal.usecase.impl.DeleteUserUseCaseImpl
import com.example.pricingpal.usecase.impl.GetUserUseCaseImpl
import com.example.pricingpal.usecase.impl.LoginUseCaseImpl
import com.example.pricingpal.usecase.impl.RetrieveUseCaseImpl
import com.example.pricingpal.usecase.impl.SignUpUseCaseImpl
import com.example.pricingpal.usecase.impl.UpdateEmailUseCaseImpl
import com.example.pricingpal.usecase.impl.UpdatePasswordUseCaseImpl
import com.example.pricingpal.usecase.impl.UpdateUseCaseImpl
import com.example.pricingpal.usecase.impl.UpdateUserUseCaseImpl
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


    @Binds
    abstract fun bindUpdateUseCase(impl: UpdateUseCaseImpl): UpdateUseCase
    @Binds
    abstract fun bindUpdateEmailUseCase(impl: UpdateEmailUseCaseImpl): UpdateEmailUseCase

    @Binds
    abstract fun bindUpdatePasswordUseCase(impl: UpdatePasswordUseCaseImpl): UpdatePasswordUseCase

    @Binds
    abstract fun bindRetrieveUseCase(impl: RetrieveUseCaseImpl): RetrieveUseCase

}