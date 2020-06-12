package com.myfirstownapp.beeapp

import org.springframework.stereotype.Service

@Service
class DbService(val repository: UserRepository) {

}