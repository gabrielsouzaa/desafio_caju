package com.challenge.factorymethod.transaction.impl

import com.challenge.factorymethod.enum.TransactionCodeEnum
import com.challenge.factorymethod.model.PayloadTransaction
import com.challenge.factorymethod.model.ResponseTransaction
import com.challenge.factorymethod.repository.AccountRepository
import com.challenge.factorymethod.transaction.Transaction

class FoodTransaction: Transaction() {

    override fun processTransaction(payload: PayloadTransaction) {
        repository = AccountRepository()
        val account = repository.getById(payload.account)
        println("Process food transaction with food balance")
        account?.let {
            verifyAvailableAmount(payload.amount, it.foodBalance)
            when(code) {
                TransactionCodeEnum.SUCCESS.code -> {
                    repository.save(account.copy(foodBalance = it.foodBalance - payload.amount))
                }
                TransactionCodeEnum.INSUFFICIENT_FUNDS.code -> {
                    println("Process food transaction with cash balance")
                    verifyAvailableAmount(payload.amount, it.cashBalance)
                    repository.save(account.copy(cashBalance = it.cashBalance - payload.amount))
                }
                else -> {
                    println("Invalid transaction")
                }
            }
        }
    }

}