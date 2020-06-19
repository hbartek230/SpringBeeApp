package com.myfirstownapp.beeapp.usecases

import com.myfirstownapp.beeapp.harvest.AddHarvestRequest
import com.myfirstownapp.beeapp.harvest.HarvestMapper
import com.myfirstownapp.beeapp.harvest.HarvestRepository
import com.myfirstownapp.beeapp.summary.HoneySummaryDomain
import com.myfirstownapp.beeapp.summary.HoneySummaryMapper
import com.myfirstownapp.beeapp.summary.HoneySummaryRepository
import org.springframework.stereotype.Component

@Component
class AddHarvestUseCase(
        private val harvestRepository: HarvestRepository,
        private val honeySummaryRepository: HoneySummaryRepository,
        private val summaryMapper: HoneySummaryMapper
) {

    fun invoke(addRequest: AddHarvestRequest, mapper: HarvestMapper): Long {
        harvestRepository.save(mapper.mapRequestToHarvestDto(addRequest))
        updateHoneySummary(honeySummaryRepository, addRequest)
        return addRequest.honeyId
    }

    private fun updateHoneySummary(honeySummaryRepository: HoneySummaryRepository, addRequest: AddHarvestRequest) {
        val updatedHoneyState: HoneySummaryDomain
        if (honeySummaryRepository.existsByHoneyIdAndUserId(addRequest.honeyId, addRequest.userId)) {
            val actualHoneyState: HoneySummaryDomain = summaryMapper.mapToHoneySummaryDomain(honeySummaryRepository
                    .findByHoneyIdAndUserId(addRequest.honeyId, addRequest.userId))
            updatedHoneyState = HoneySummaryDomain(
                    id = actualHoneyState.id,
                    userId = actualHoneyState.userId,
                    honeyId = actualHoneyState.honeyId,
                    honeyUnits = actualHoneyState.honeyUnits + addRequest.honeyUnits,
                    honeyPacks = actualHoneyState.honeyPacks + addRequest.honeyPacks
            )
        } else {
            updatedHoneyState = HoneySummaryDomain(
                    userId = addRequest.userId,
                    honeyId = addRequest.honeyId,
                    honeyUnits = addRequest.honeyUnits,
                    honeyPacks = addRequest.honeyPacks
            )
        }
        honeySummaryRepository.save(summaryMapper.mapToHoneySummaryDto(updatedHoneyState))
    }
}