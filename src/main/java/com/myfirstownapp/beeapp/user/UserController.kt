package com.myfirstownapp.beeapp.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val serviceUser: UserDbService) {

    @GetMapping
    fun getUsers(): List<User> = serviceUser.getAllUsers()
}