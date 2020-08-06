package com.myfirstownapp.beeapp.harvest

data class AddHarvestRequest(
        val userId: Long,
        val honeyId: Long,
        val honeyUnits: Long,
        val honeyPacks: Int
)