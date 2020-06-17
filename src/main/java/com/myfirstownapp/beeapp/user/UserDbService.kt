package com.myfirstownapp.beeapp.user

import org.springframework.stereotype.Service

@Service
class UserDbService(private val repository: UserRepository) {

    fun getAllUsers(): List<User> = repository.findAll().toList()
}