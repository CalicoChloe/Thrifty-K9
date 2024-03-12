package com.example.pricingpal.usecase

import com.example.pricingpal.model.datatransferobjects.OrganizationDTO

interface GetOrganizationUseCase: UseCase<GetOrganizationUseCase.Input, GetOrganizationUseCase.Output>
{
    class Input(val orgName: String)
    sealed class Output() {
        class Success(val orgName: OrganizationDTO): Output()
        object Failure: Output()
    }
}