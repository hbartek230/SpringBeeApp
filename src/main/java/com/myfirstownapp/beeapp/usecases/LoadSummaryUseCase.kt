package com.myfirstownapp.beeapp.usecases

import com.myfirstownapp.beeapp.summary.HoneySummaryDto
import com.myfirstownapp.beeapp.summary.HoneySummaryRepository
import org.springframework.stereotype.Component

@Component
class LoadSummaryUseCase(
        private val summaryRepository: HoneySummaryRepository
) {
    fun invoke(userId: Long, honeyId: Long?): List<HoneySummaryDto> = honeyId?.run {
        listOf(summaryRepository.findByUserIdAndHoneyId(userId, honeyId))
    } ?: summaryRepository.findByUserId(userId)
}