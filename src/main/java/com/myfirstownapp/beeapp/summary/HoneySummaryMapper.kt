package com.myfirstownapp.beeapp.summary

import org.springframework.stereotype.Component

@Component
class HoneySummaryMapper {
    fun mapToHoneySummaryDomain(honeySummaryDto: HoneySummaryDto): HoneySummaryDomain {
        return HoneySummaryDomain(
                honeySummaryDto.id,
                honeySummaryDto.userId,
                honeySummaryDto.honeyId,
                honeySummaryDto.honeyUnits,
                honeySummaryDto.honeyPacks
        )
    }

    fun mapToHoneySummaryDto(honeySummaryDomain: HoneySummaryDomain): HoneySummaryDto {
        return HoneySummaryDto(
                honeySummaryDomain.id ?: 0,
                honeySummaryDomain.userId,
                honeySummaryDomain.honeyId,
                honeySummaryDomain.honeyUnits,
                honeySummaryDomain.honeyPacks
        )
    }

    fun mapToHoneySummaryDomainList(honeySummaryDtoList: List<HoneySummaryDto>): List<HoneySummaryDomain> {
        return honeySummaryDtoList
                .map { t -> HoneySummaryDomain(t.id, t.userId, t.honeyId, t.honeyUnits, t.honeyPacks) }
    }
}