package com.myfirstownapp.beeapp.harvest

import javax.persistence.*

@Entity
@Table(name = "harvest")
data class HarvestDto(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
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