package com.myfirstownapp.beeapp.harvest

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/beeapp/harvest")
class HarvestController (private val service:HarvestDbService){

    @GetMapping(value = ["getHarvest"])
    fun getAllHarvest(): List<Harvest> = service.getAllHarvest()

    @GetMapping(value = ["getHarvest/{kind}"])
    fun getHarvestByKind(@PathVariable ("kind") kind: String): List<Harvest> {
        return service.getHarvestByKind(kind)
    }

    @PostMapping(value = ["addHarvest"], consumes = [APPLICATION_JSON_VALUE])
    fun addHarvest(@RequestBody harvest: Harvest): Harvest = service.addHarvest(harvest)

}