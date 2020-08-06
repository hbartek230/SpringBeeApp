package com.myfirstownapp.beeapp.summary

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/honey_summary")
class HoneySummaryController (
        private val honeySummaryService: HoneySummaryService,
        private val summaryMapper: HoneySummaryMapper
){

    @GetMapping
    fun findSummaryByHoneyOrUser(@RequestParam(required = true)userId: Long,
                                 @RequestParam(required = false)honeyId: Long?): List<HoneySummaryDomain>{
        return summaryMapper.mapToHoneySummaryDomainList(honeySummaryService.getHoneySummary(userId, honeyId))
    }
}