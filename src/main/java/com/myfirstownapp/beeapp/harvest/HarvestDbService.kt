package com.myfirstownapp.beeapp.harvest

import com.myfirstownapp.beeapp.harvest.summary.HarvestSummary
import com.myfirstownapp.beeapp.harvest.summary.HarvestSummaryDto
import com.myfirstownapp.beeapp.harvest.summary.HarvestSummaryMapper
import com.myfirstownapp.beeapp.harvest.summary.HarvestSummaryRepository
import org.springframework.stereotype.Service

@Service
class HarvestDbService(
        private val summaryRepository: HarvestSummaryRepository,
        private val summaryMapper: HarvestSummaryMapper,
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

        val harvestSummaryDto: HarvestSummaryDto = updateHarvestSummary(harvestRequest)?.run {
            summaryMapper.mapToHarvestSummaryDto(this)
        } ?: createNewHoney(harvestRequest)
        summaryRepository.save(harvestSummaryDto)

        return mapper.mapToHarvest(harvestDto)
    }

    private fun createNewHoney(harvestRequest: AddHarvestRequest): HarvestSummaryDto =
            HarvestSummaryDto(
                    kind = harvestRequest.kind.honeyKindName,
                    summaryUnits = harvestRequest.kilograms.toLong(),
                    summaryGlasses = harvestRequest.glasses.toLong()
            )

    private fun findSummaryByKind(kind: String): HarvestSummary? {
        val harvestSummaryDto = summaryRepository.findByKind(kind)
        return harvestSummaryDto?.run { summaryMapper.mapToHarvestSummary(this) }
    }

    private fun updateHarvestSummary(harvestRequest: AddHarvestRequest): HarvestSummary? {
        return findSummaryByKind(harvestRequest.kind.honeyKindName)?.run {
            copy(
                    summaryGlasses = summaryGlasses + harvestRequest.glasses,
                    summaryUnits = summaryUnits + harvestRequest.kilograms
            )
        }
    }
}