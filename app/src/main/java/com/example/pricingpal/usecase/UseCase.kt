package com.example.pricingpal.usecase

interface UseCase<InputT, OutputT> {
    suspend fun execute(input: InputT): OutputT
}