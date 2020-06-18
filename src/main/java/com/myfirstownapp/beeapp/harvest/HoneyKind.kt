package com.myfirstownapp.beeapp.harvest

enum class HoneyKind(
        val honeyKindName: String
) {
    ROPE("rope"),
    POLLEN("pollen"),
    ACACIA("acacia");

    companion object {
        fun findKindByName(kind: String): HoneyKind {
            return values().toList().first { it.honeyKindName == kind }
        }
    }
}
