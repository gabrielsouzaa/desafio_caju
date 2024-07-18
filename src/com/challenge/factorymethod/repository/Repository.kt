package com.challenge.factorymethod.repository

import com.challenge.factorymethod.model.Account

interface Repository {
    fun getById(id: String): Account?
    fun save(account: Account)
}