package com.myfirstownapp.beeapp.harvest

import org.springframework.data.repository.CrudRepository

interface HarvestRepository : CrudRepository<Harvest, Long> {

    fun findByKind(kind: String): List<Harvest>
}