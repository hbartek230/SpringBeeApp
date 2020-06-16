package com.myfirstownapp.beeapp.harvest

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/harvest")
class HarvestController(private val service: HarvestDbService) {

    @GetMapping
    fun getHarvestByKind(@RequestParam(required = false) kind: String?): List<Harvest> {
        return service.getHarvestByKind(kind)
    }

    @PostMapping(value = ["add"], consumes = [APPLICATION_JSON_VALUE])
    fun addHarvest(@RequestBody harvest: Harvest): Harvest = service.addHarvest(harvest)

}