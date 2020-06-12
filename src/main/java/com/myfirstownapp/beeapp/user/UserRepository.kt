package com.myfirstownapp.beeapp.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    override fun findAll(): List<User>
}