package com.myfirstownapp.beeapp

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/beeapp/users")
class UserController(private val serviceUser: UserDbService) {

    @GetMapping(value = ["getUsers"])
    fun getUsers(): MutableList<User> = serviceUser.getAllUsers()
}