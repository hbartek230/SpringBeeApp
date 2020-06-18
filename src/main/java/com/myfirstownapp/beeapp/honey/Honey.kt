package com.myfirstownapp.beeapp.honey

import javax.persistence.*

@Entity
@Table(name = "honeys")
data class Honey (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Column(name = "honey_name")
        val honeyName: String = ""
)