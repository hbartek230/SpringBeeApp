package com.myfirstownapp.beeapp.harvest

data class HarvestDomain (
        val id: Long = 0,
        val userId: Long,
        val honeyId: Long,
        val honeyUnits: Long,
        val honeyPacks: Int
)