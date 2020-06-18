package com.myfirstownapp.beeapp.honey

import org.springframework.data.repository.CrudRepository

interface HoneyRepository : CrudRepository<HoneyDto, Long> {
}