package com.myfirstownapp.beeapp.honey

import javax.persistence.*

@Entity
@Table(name = "honeys")
data class HoneyDto (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", unique = true)
        val id: Long = 0,
        @Column(name = "honey_name")
        val honeyName: String = ""
)