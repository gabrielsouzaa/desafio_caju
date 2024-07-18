package com.challenge.factorymethod.transaction.factory

import com.challenge.factorymethod.transaction.Transaction
import com.challenge.factorymethod.transaction.impl.FoodTransaction

class FoodTransactionFactory: TransactionFactory() {
    override fun createTransaction(): Transaction {
        return FoodTransaction()
    }
}