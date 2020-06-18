package com.myfirstownapp.beeapp.usecases

import com.myfirstownapp.beeapp.harvest.HarvestDto
import com.myfirstownapp.beeapp.harvest.HarvestRepository
import org.springframework.stereotype.Component

@Component
class LoadHarvestUseCase(
        private val repository: HarvestRepository
) {

    fun invoke(honeyId: Long?): List<HarvestDto> = honeyId?.run {
        repository.findByHoneyId(honeyId)
    } ?: getAllHarvest()

    private fun getAllHarvest(): List<HarvestDto> = repository.findAll().toList()
}