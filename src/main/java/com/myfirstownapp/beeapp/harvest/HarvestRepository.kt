package com.myfirstownapp.beeapp.harvest

import org.springframework.data.repository.CrudRepository

interface HarvestRepository : CrudRepository<Harvest, Long> {
    override fun findAll(): List<Harvest>

    fun findByKind(kind: String): List<Harvest>
}