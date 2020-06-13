package com.myfirstownapp.beeapp.harvest

import javax.persistence.*

@Entity
@Table(name = "harvest")
data class Harvest(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Column(name = "kind")
        val kind: String = "",
        @Column(name = "kilograms")
        val kilograms: Int = 0,
        @Column(name = "glasses")
        val glasses: Int = 0
)