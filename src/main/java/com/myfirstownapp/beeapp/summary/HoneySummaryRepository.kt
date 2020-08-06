package com.myfirstownapp.beeapp.summary

import org.springframework.data.repository.CrudRepository

interface HoneySummaryRepository : CrudRepository<HoneySummaryDto, Long> {
    fun existsByUserIdAndHoneyId(userId: Long, honeyId: Long): Boolean

    fun findByUserIdAndHoneyId(userId: Long, honeyId: Long?): HoneySummaryDto

    fun findByUserId(userId: Long): List<HoneySummaryDto>
}