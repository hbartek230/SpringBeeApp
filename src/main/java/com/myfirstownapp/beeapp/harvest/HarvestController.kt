package com.myfirstownapp.beeapp.harvest

import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/harvest")
class HarvestController (
        private val service: HarvestDbService,
        private val mapper: HarvestMapper
){

    @GetMapping
    fun getHarvestByKind(@RequestParam(required = false) honeyId: Long?) : List<HarvestDomain> {
        return mapper.mapToHarvestModelList(service.loadHarvest(honeyId))
    }

    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun uploadHoneyData(@RequestBody harvestRequest: AddHarvestRequest){
        service.addHarvest(harvestRequest)
    }
}