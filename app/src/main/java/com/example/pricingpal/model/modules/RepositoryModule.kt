package com.example.pricingpal.model.modules

import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.ItemRepository
import com.example.pricingpal.model.repositories.impl.CategoryRepositoryImpl
import com.example.pricingpal.model.repositories.impl.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * This class creates a Dagger Hilt module that provides Dagger Hilt with information
 * on how to bind abstract classes to their corresponding implementations.
 *
 * @author Abdoulie NJie
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    /**
     * This function uses the @Binds annotation to bind an abstract CategoryRepository
     * class its implementation, which informs Dagger Hilt to use CategoryRepositoryImpl
     * whenever an instance of CategoryRepository is required.
     *
     * @param impl reference to the CategoryRepositoryImpl
     *
     */
    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    /**
     * This function uses the @Binds annotation to bind an abstract ItemRepository
     * class its implementation, which informs Dagger Hilt to use ItemRepositoryImpl
     * whenever an instance of CategoryRepository is required.
     *
     * @param impl reference to the ItemRepositoryImpl
     *
     */
    @Binds
    abstract fun bindItemRepository(impl: ItemRepositoryImpl): ItemRepository
}