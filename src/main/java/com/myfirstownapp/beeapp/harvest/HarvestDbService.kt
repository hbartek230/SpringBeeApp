package com.myfirstownapp.beeapp.harvest

import org.springframework.stereotype.Service

@Service
class HarvestDbService(
        private val repository: HarvestRepository,
        private val mapper: HarvestMapper
) {

    fun getHarvestByKind(kind: String?): List<HarvestDto> = kind?.run {
        repository.findByKind(kind)
    } ?: getAllHarvest()

    private fun getAllHarvest(): List<HarvestDto> = repository.findAll().toList()

    fun addHarvest(harvestRequest: AddHarvestRequest): Harvest {
        val harvestDto = mapper.mapToHarvestDto(harvestRequest)
                .let { harvestDto -> repository.save(harvestDto) }

        return mapper.mapToHarvest(harvestDto)
    }
}