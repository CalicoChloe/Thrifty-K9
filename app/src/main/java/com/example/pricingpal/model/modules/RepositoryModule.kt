package com.example.pricingpal.model.modules

import com.example.pricingpal.model.repositories.AuthRepository
import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.ItemRepository
import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.model.repositories.UserRepository
import com.example.pricingpal.model.repositories.impl.AuthRepositoryImpl
import com.example.pricingpal.model.repositories.impl.CategoryRepositoryImpl
import com.example.pricingpal.model.repositories.impl.ItemRepositoryImpl
import com.example.pricingpal.model.repositories.impl.OrganizationRepositoryImpl
import com.example.pricingpal.model.repositories.impl.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Class: RepositoryModule
 * @author Abdoulie NJie
 * @version 2
 * @written 3/06/2024
 * This class creates a Dagger Hilt module that provides Dagger Hilt with information
 * on how to bind abstract classes to their corresponding implementations.
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    /**
     * This function uses the @Binds annotation to bind an abstract CategoryRepository
     * class its implementation, which informs Dagger Hilt to use CategoryRepositoryImpl
     * whenever an instance of CategoryRepository is required.
     *
     * @author Abdoulie NJie
     * @param impl reference to the CategoryRepositoryImpl
     *
     *
     */
    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    /**
     * This function uses the @Binds annotation to bind an abstract ItemRepository
     * class its implementation, which informs Dagger Hilt to use ItemRepositoryImpl
     * whenever an instance of CategoryRepository is required.
     *
     * @author Abdoulie NJie
     * @param impl reference to the ItemRepositoryImpl
     *
     */
    @Binds
    abstract fun bindItemRepository(impl: ItemRepositoryImpl): ItemRepository


    /**
     * This function uses the @Binds annotation to bind an abstract AuthRepository
     * class its implementation, which informs Dagger Hilt to use AuthRepositoryImpl
     * whenever an instance of AuthRepository is required.
     *
     * @author Chloe Jackson
     * @param impl reference to the AuthRepositoryImpl
     *
     */
    @Binds
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    /**
     * This function uses the @Binds annotation to bind an abstract OrganizationRepository
     * class its implementation, which informs Dagger Hilt to use OrganizationRepositoryImpl
     * whenever an instance of OrganizationRepository is required.
     *
     * @author Abdoulie NJie
     * @param impl reference to the OrganizationRepositoryImpl
     *
     */
    @Binds
    abstract fun bindOrganizationRepository(impl: OrganizationRepositoryImpl): OrganizationRepository

    /**
     * This function uses the @Binds annotation to bind an abstract UserRepository
     * class its implementation, which informs Dagger Hilt to use UserRepositoryImpl
     * whenever an instance of UserRepository is required.
     *
     * @author Abdoulie NJie
     * @param impl reference to the UserRepositoryImpl
     *
     */
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository
}