package com.myfirstownapp.beeapp.user

import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserDto, Long> {
}