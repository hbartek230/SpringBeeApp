package com.myfirstownapp.beeapp.harvest

import org.springframework.stereotype.Service

@Service
class HarvestDbService(private val repository: HarvestRepository) {
    fun getAllHarvest(): List<Harvest> = repository.findAll()

    fun getHarvestByKind(kind: String): List<Harvest> = repository.findByKind(kind)

    fun addHarvest(harvest: Harvest): Harvest = repository.save(harvest)
}