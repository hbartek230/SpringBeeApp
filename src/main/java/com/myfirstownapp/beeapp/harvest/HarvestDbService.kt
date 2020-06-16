package com.myfirstownapp.beeapp.harvest

import org.springframework.stereotype.Service

@Service
class HarvestDbService(private val repository: HarvestRepository) {

    fun getHarvestByKind(kind: String?): List<Harvest> = kind?.run{
        repository.findByKind(kind)
    } ?: getAllHarvest()

    private fun getAllHarvest(): List<Harvest> = repository.findAll().toList()

    fun addHarvest(harvest: Harvest): Harvest = repository.save(harvest)
}