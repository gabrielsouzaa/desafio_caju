package com.challenge.factorymethod.repository

import com.challenge.factorymethod.model.Account

class AccountRepository: Repository {

    private var listOfAccounts = mutableListOf<Account>()

    private fun mockRepository() {
        listOfAccounts.add(Account("1", 100.0,100.0,200.0))
        listOfAccounts.add(Account("2", 200.0, 200.0, 300.0))
        listOfAccounts.add(Account("3", 300.0, 300.0, 300.0))
    }

    override fun getById(id: String): Account? {
        mockRepository()
        return listOfAccounts.firstOrNull { it.id == id }
    }

    override fun save(account: Account) {
        println("action=savingAccount, account=$account")
    }

}