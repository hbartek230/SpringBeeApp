package com.myfirstownapp.beeapp.summary

import org.springframework.data.repository.CrudRepository

interface HoneySummaryRepository : CrudRepository<HoneySummaryDto, Long> {
    fun existsByHoneyIdAndUserId(honeyId: Long, userId: Long): Boolean

    fun findByHoneyIdAndUserId(honeyId: Long, userId: Long): HoneySummaryDto
}