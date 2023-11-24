package com.example.pricingpal.model.di



import com.example.pricingpal.model.repositories.CategoryRepository
import com.example.pricingpal.model.repositories.CategoryRepositoryImpl
import com.example.pricingpal.model.repositories.ItemRepository
import com.example.pricingpal.model.repositories.ItemRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindCategoryRepository(impl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun bindItemRepository(impl: ItemRepositoryImpl): ItemRepository

}