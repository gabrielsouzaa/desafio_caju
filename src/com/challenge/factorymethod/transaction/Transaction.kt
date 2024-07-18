package com.challenge.factorymethod.transaction

import com.challenge.factorymethod.enum.TransactionCodeEnum
import com.challenge.factorymethod.model.PayloadTransaction
import com.challenge.factorymethod.model.ResponseTransaction
import com.challenge.factorymethod.repository.Repository

abstract class Transaction {

    lateinit var repository: Repository
    lateinit var code: String

    abstract fun processTransaction(payload: PayloadTransaction)

    fun verifyAvailableAmount(amount: Double, totalAmount: Double): String {
        try {
            code = if (amount <= totalAmount) {
                TransactionCodeEnum.SUCCESS.code
            } else {
                println("Insufficient funds")
                TransactionCodeEnum.INSUFFICIENT_FUNDS.code
            }
            return code
        } catch (e: Exception) {
            code = TransactionCodeEnum.INVALID_TRANSACTION.code
            return code
        }
    }

    fun getResponseTransaction(): ResponseTransaction {
        return ResponseTransaction(code)
    }

}