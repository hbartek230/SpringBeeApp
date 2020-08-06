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
        private val summaryMapper: HoneySummaryMapper,
        private val harvestMapper: HarvestMapper
) {

    fun invoke(addRequest: AddHarvestRequest): Long {
        harvestRepository.save(harvestMapper.mapRequestToHarvestDto(addRequest))
        addOrUpdateHoneySummary(addRequest)
        return addRequest.honeyId
    }

    private fun addOrUpdateHoneySummary(addRequest: AddHarvestRequest) {
        val updatedHoneyState: HoneySummaryDomain =
                if (honeySummaryRepository.existsByUserIdAndHoneyId(addRequest.userId, addRequest.honeyId)) {
            updateExistingHoney(addRequest)
        } else {
            createHoneySummary(addRequest)
        }
        honeySummaryRepository.save(summaryMapper.mapToHoneySummaryDto(updatedHoneyState))
    }

    private fun updateExistingHoney(addRequest: AddHarvestRequest): HoneySummaryDomain {
        val actualHoneyState: HoneySummaryDomain = summaryMapper.mapToHoneySummaryDomain(honeySummaryRepository
                .findByUserIdAndHoneyId(addRequest.userId, addRequest.honeyId))
        return actualHoneyState.copy(
                honeyUnits = actualHoneyState.honeyUnits + addRequest.honeyUnits,
                honeyPacks = actualHoneyState.honeyPacks + addRequest.honeyPacks
        )
    }

    private fun createHoneySummary(addRequest: AddHarvestRequest): HoneySummaryDomain =
            HoneySummaryDomain(
                    userId = addRequest.userId,
                    honeyId = addRequest.honeyId,
                    honeyUnits = addRequest.honeyUnits,
                    honeyPacks = addRequest.honeyPacks
            )
}