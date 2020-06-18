package com.myfirstownapp.beeapp.usecases

import com.myfirstownapp.beeapp.harvest.AddHarvestRequest
import com.myfirstownapp.beeapp.harvest.HarvestMapper
import com.myfirstownapp.beeapp.harvest.HarvestRepository
import org.springframework.stereotype.Component

@Component
class AddHarvestUseCase(
        private val harvestRepository: HarvestRepository,
        private val updateUseCase: UpdateSummaryUseCase
) {

    fun invoke(addRequest: AddHarvestRequest, mapper: HarvestMapper): Long {
        harvestRepository.save(mapper.mapRequestToHarvestDto(addRequest))
        updateUseCase.invoke(addRequest)
        return addRequest.honeyId
    }
}