package com.myfirstownapp.beeapp.harvest.summary

import com.myfirstownapp.beeapp.harvest.HoneyKind

data class HarvestSummary (
        val id: Long,
        val kind: HoneyKind,
        val summaryUnits: Long,
        val summaryGlasses: Long
)