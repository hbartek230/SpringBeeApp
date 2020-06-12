package com.myfirstownapp.beeapp

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    override fun findAll(): MutableList<User>
}