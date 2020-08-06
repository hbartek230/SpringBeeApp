package com.myfirstownapp.beeapp.user

import javax.persistence.*

@Entity
@Table(name = "users")
data class UserDto(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", unique = true)
        val id: Long = 0,
        @Column(name = "username")
        val username: String = "",
        @Column(name = "password")
        val password: String = ""
)