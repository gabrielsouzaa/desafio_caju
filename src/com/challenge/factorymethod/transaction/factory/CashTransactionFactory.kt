package com.challenge.factorymethod.transaction.factory

import com.challenge.factorymethod.transaction.Transaction
import com.challenge.factorymethod.transaction.impl.CashTransaction

class CashTransactionFactory: TransactionFactory() {
    override fun createTransaction(): Transaction {
        return CashTransaction()
    }
}