package com.myfirstownapp.beeapp.harvest

data class AddHarvestRequest(
        val kind: HoneyKind,
        val kilograms: Int,
        val glasses: Int
)