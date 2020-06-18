package com.myfirstownapp.beeapp.usecases

import com.myfirstownapp.beeapp.harvest.AddHarvestRequest
import com.myfirstownapp.beeapp.summary.HoneySummaryRepository
import org.springframework.stereotype.Component

@Component
class UpdateSummaryUseCase(
        private val honeySummaryRepository: HoneySummaryRepository
) {
    fun invoke(addRequest: AddHarvestRequest): Long {

        return addRequest.honeyId
    }
}