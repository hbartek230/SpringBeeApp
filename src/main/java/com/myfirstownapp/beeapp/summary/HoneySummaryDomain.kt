package com.myfirstownapp.beeapp.summary

data class HoneySummaryDomain(
        val id: Long? = null,
        val userId: Long,
        val honeyId: Long,
        val honeyUnits: Long,
        val honeyPacks: Int
)