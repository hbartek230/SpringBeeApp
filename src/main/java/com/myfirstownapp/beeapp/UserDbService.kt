package com.myfirstownapp.beeapp

import org.springframework.stereotype.Service

@Service
class UserDbService(private val repository: UserRepository) {

    fun getAllUsers(): MutableList<User> = repository.findAll()
}