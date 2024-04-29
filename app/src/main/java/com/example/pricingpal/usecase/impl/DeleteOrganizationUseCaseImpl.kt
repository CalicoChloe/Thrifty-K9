package com.example.pricingpal.usecase.impl

import com.example.pricingpal.model.repositories.OrganizationRepository
import com.example.pricingpal.usecase.DeleteOrganizationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DeleteOrganizationUseCaseImpl @Inject constructor(private val organizationRepository: OrganizationRepository):
    DeleteOrganizationUseCase {
    override suspend fun execute(input: DeleteOrganizationUseCase.Input): DeleteOrganizationUseCase.Output =
        withContext(Dispatchers.IO) {
            val result = organizationRepository.deleteOrganization(input.orgName, input.isOwner)
            if (result) {
                DeleteOrganizationUseCase.Output.Success
            } else {
                DeleteOrganizationUseCase.Output.Failure
            }
    }
}
