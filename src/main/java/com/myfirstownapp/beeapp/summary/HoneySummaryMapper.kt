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
}