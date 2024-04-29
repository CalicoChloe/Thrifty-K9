package com.example.pricingpal.usecase

interface DeleteOrganizationUseCase : UseCase<DeleteOrganizationUseCase.Input, DeleteOrganizationUseCase.Output> {


    data class Input(
        val orgName: String,
        val isOwner: Boolean)
    sealed class Output {
        object Success : Output()
        object Failure: Output()
    }
}