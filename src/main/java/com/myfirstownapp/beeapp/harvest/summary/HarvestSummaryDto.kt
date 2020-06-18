package com.myfirstownapp.beeapp.harvest.summary

import javax.persistence.*

@Entity
@Table(name = "harvest_summary")
data class HarvestSummaryDto(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Column(name = "honey_kind")
        val kind: String = "",
        @Column(name = "summary_units")
        val summaryUnits: Long = 0,
        @Column(name = "summary_glasses")
        val summaryGlasses: Long = 0
)