package com.myfirstownapp.beeapp.summary

import javax.persistence.*

@Entity
@Table(name = "harvest_summary")
data class HoneySummaryDto(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true)
        val id: Long = 0,

        @Column(name = "userId")
        val userId: Long = 0,

        @Column(name = "honeyId")
        val honeyId: Long = 0,

        @Column(name = "honey_units")
        val honeyUnits: Long = 0,

        @Column(name = "honey_packs")
        val honeyPacks: Int = 0
)