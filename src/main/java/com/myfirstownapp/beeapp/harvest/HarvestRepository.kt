package com.myfirstownapp.beeapp.harvest

import org.springframework.data.repository.CrudRepository

interface HarvestRepository : CrudRepository<HarvestDto, Long> {

    fun findByKind(kind: String): List<HarvestDto>
}