package com.example.pricingpal.usecase

/**
 * Interface: UseCase
 * @author Abdoulie NJie
 * @version 1
 * @written 03/06/2024
 * This interface contains a generic function that is used to take an input into it's parameters, and return a result/ output
 */

interface UseCase<InputT, OutputT> {
    suspend fun execute(input: InputT): OutputT
}