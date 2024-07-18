package com.challenge.factorymethod.transaction.factory

import com.challenge.factorymethod.model.PayloadTransaction
import com.challenge.factorymethod.model.ResponseTransaction
import com.challenge.factorymethod.transaction.Transaction

abstract class TransactionFactory {
    fun processTransaction(payloadTransaction: PayloadTransaction): ResponseTransaction {
        val transaction = createTransaction()
        transaction.processTransaction(payloadTransaction)
        return transaction.getResponseTransaction()
    }
    abstract fun createTransaction(): Transaction
}