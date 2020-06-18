package com.myfirstownapp.beeapp.harvest

import org.springframework.stereotype.Component

@Component
class HarvestMapper {
    fun mapRequestToHarvestDto(addRequest: AddHarvestRequest): HarvestDto{
        return HarvestDto(
                userId = addRequest.userId,
                honeyId = addRequest.honeyId,
                honeyUnits = addRequest.honeyUnits,
                honeyPacks = addRequest.honeyPacks
        )
    }

    fun mapToHarvestDto(harvestDomain: HarvestDomain): HarvestDto {
        return HarvestDto(
                harvestDomain.id,
                harvestDomain.userId,
                harvestDomain.honeyId,
                harvestDomain.honeyUnits,
                harvestDomain.honeyPacks
        )
    }

    fun mapToHarvestDomain(harvestDto: HarvestDto): HarvestDomain {
        return HarvestDomain(
                harvestDto.id,
                harvestDto.userId,
                harvestDto.honeyId,
                harvestDto.honeyUnits,
                harvestDto.honeyPacks
        )
    }

    fun mapToHarvestModelList(harvestDtoList: List<HarvestDto>): List<HarvestDomain> {
        return harvestDtoList.map { t -> HarvestDomain(t.id, t.userId, t.honeyId, t.honeyUnits, t.honeyPacks) }
    }
}