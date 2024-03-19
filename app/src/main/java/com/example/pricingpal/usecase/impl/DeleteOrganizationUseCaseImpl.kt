package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.usecase.DeleteOrganizationUseCase
import javax.inject.Inject

class DeleteOrganizationUseCaseImpl @Inject constructor(private val organizationRepository: OrganizationRepository):
    DeleteOrganizationUseCase {
    override suspend fun execute(input: DeleteOrganizationUseCase.Input): DeleteOrganizationUseCase.Output {
        organizationRepository.deleteOrganization(input.orgName, input.isOwner)
        return DeleteOrganizationUseCase.Output.Success
    }
}
