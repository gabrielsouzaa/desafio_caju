package com.challenge.factorymethod.transaction.impl

import com.challenge.factorymethod.enum.TransactionCodeEnum
import com.challenge.factorymethod.model.PayloadTransaction
import com.challenge.factorymethod.model.ResponseTransaction
import com.challenge.factorymethod.repository.AccountRepository
import com.challenge.factorymethod.repository.Repository
import com.challenge.factorymethod.transaction.Transaction

class CashTransaction: Transaction() {

    override fun processTransaction(payload: PayloadTransaction) {
        repository = AccountRepository()
        val account = repository.getById(payload.account)
        println("Process cash transaction")
        account?.let {
            verifyAvailableAmount(payload.amount, it.cashBalance)
            if (code == TransactionCodeEnum.SUCCESS.code) {
                repository.save(account.copy(cashBalance = it.cashBalance - payload.amount))
            }
        }
    }

}