package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.usecase.GetOrganizationUseCase
import javax.inject.Inject

class GetOrganizationUseCaseImpl @Inject constructor(private val organizationRepository: OrganizationRepository):
    GetOrganizationUseCase {
    override suspend fun execute(input: GetOrganizationUseCase.Input): GetOrganizationUseCase.Output {
        val orgName = organizationRepository.getOrganization(input.orgName)
        return GetOrganizationUseCase.Output.Success(orgName)
    }
}