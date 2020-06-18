package com.myfirstownapp.beeapp.summary

class HoneySummaryDomain(
        val id: Long = 0,
        val userId: Long,
        val honeyId: Long,
        val honeyUnits: Long,
        val honeyPacks: Int
)