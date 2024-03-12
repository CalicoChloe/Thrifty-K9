package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.usecase.UpdateOrganizationUseCase
import javax.inject.Inject

class UpdateOrganizationUseCaseImpl @Inject constructor(private val organizationRepository: OrganizationRepository):
    UpdateOrganizationUseCase {
        override suspend fun execute(input: UpdateOrganizationUseCase.Input): UpdateOrganizationUseCase.Output {
           organizationRepository.updateOrganization(input.orgName)
                return UpdateOrganizationUseCase.Output.Success
        }
}