package com.myfirstownapp.beeapp.harvest.summary

import com.myfirstownapp.beeapp.harvest.HoneyKind
import org.springframework.stereotype.Component

@Component
class HarvestSummaryMapper {
    fun mapToHarvestSummaryDto(harvestSummary: HarvestSummary): HarvestSummaryDto {
        return HarvestSummaryDto(
                kind = harvestSummary.kind.honeyKindName,
                summaryUnits = harvestSummary.summaryUnits,
                summaryGlasses = harvestSummary.summaryGlasses
        )
    }

    fun mapToHarvestSummary(harvestSummaryDto: HarvestSummaryDto): HarvestSummary {
        return HarvestSummary(harvestSummaryDto.id,
                HoneyKind.findKindByName(harvestSummaryDto.kind),
                harvestSummaryDto.summaryUnits,
                harvestSummaryDto.summaryGlasses
        )
    }
}