package com.myfirstownapp.beeapp.summary

import com.myfirstownapp.beeapp.usecases.LoadSummaryUseCase
import org.springframework.stereotype.Service

@Service
class HoneySummaryService (
        private val loadSummary: LoadSummaryUseCase
){
    fun getHoneySummary(userId: Long, honeyId: Long?): List<HoneySummaryDto> = loadSummary.invoke(userId, honeyId)
}