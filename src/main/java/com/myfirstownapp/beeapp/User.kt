package com.myfirstownapp.beeapp

import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,
        @Column(name = "username")
        val username: String = "",
        @Column(name = "password")
        val password: String = ""
) 