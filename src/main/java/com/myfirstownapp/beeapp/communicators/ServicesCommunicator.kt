package com.myfirstownapp.beeapp.communicators

import com.myfirstownapp.beeapp.harvest.HarvestRepository
import com.myfirstownapp.beeapp.honey.HoneyRepository
import com.myfirstownapp.beeapp.summary.HoneySummaryRepository
import com.myfirstownapp.beeapp.user.UserRepository
import org.springframework.stereotype.Component

@Component
class ServicesCommunicator (
        val harvestRepo: HarvestRepository,
        val honeySummaryRepo: HoneySummaryRepository,
        val honeyRepo: HoneyRepository,
        val userRepo: UserRepository
){

}