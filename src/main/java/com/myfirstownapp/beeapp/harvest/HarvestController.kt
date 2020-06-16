package com.myfirstownapp.beeapp.harvest

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/harvest")
class HarvestController(private val service: HarvestDbService) {

    @GetMapping
    fun getHarvestByKind(@RequestParam(required = false) kind: String?): List<HarvestDto> {
        return service.getHarvestByKind(kind)
    }

    @PostMapping(value = ["add"], consumes = [APPLICATION_JSON_VALUE])
    fun addHarvest(@RequestBody harvestRequest: AddHarvestRequest): Harvest =
            service.addHarvest(harvestRequest)

}