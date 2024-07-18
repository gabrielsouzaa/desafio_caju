package com.challenge.factorymethod.transaction.factory

import com.challenge.factorymethod.transaction.Transaction
import com.challenge.factorymethod.transaction.impl.MealTransaction

class MealTransactionFactory: TransactionFactory() {
    override fun createTransaction(): Transaction {
        return MealTransaction()
    }
}