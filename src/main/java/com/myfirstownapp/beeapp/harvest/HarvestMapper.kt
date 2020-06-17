package com.myfirstownapp.beeapp.harvest

import org.springframework.stereotype.Component

@Component
class HarvestMapper {

    fun mapToHarvestDto(harvestRequest: AddHarvestRequest): HarvestDto {
        return HarvestDto(
                kilograms = harvestRequest.kilograms,
                kind = harvestRequest.kind.honeyKindName,
                glasses = harvestRequest.glasses
        )
    }

    fun mapToHarvest(harvestDto: HarvestDto): Harvest {
        return Harvest(harvestDto.id,
                HoneyKind.findKindByName(harvestDto.kind),
                harvestDto.kilograms,
                harvestDto.glasses
        )
    }
}