package com.myfirstownapp.beeapp.harvest

import com.myfirstownapp.beeapp.usecases.AddHarvestUseCase
import com.myfirstownapp.beeapp.usecases.LoadHarvestUseCase
import org.springframework.stereotype.Service

@Service
class HarvestDbService(
        private val loadHarvestUseCase: LoadHarvestUseCase,
        private val addHarvestUseCase: AddHarvestUseCase
) {
    fun loadHarvest(honeyId: Long?): List<HarvestDto> = loadHarvestUseCase.invoke(honeyId)

    fun addHarvest(addRequest: AddHarvestRequest) = addHarvestUseCase.invoke(addRequest)
}
