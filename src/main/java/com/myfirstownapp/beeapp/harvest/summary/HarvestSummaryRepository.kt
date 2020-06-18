package com.myfirstownapp.beeapp.harvest.summary

import com.myfirstownapp.beeapp.harvest.HoneyKind
import org.springframework.data.repository.CrudRepository

interface HarvestSummaryRepository : CrudRepository<HarvestSummaryDto, Long> {
    fun findByKind(kind: String): HarvestSummaryDto?
}