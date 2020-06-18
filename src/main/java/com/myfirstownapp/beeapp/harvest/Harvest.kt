package com.myfirstownapp.beeapp.harvest

data class Harvest(
        val id : Long,
        val kind: HoneyKind,
        val kilograms: Int,
        val glasses: Int
)