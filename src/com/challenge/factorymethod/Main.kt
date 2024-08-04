package src.com.challenge.factorymethod

import com.challenge.factorymethod.model.PayloadTransaction
import com.challenge.factorymethod.transaction.factory.CashTransactionFactory
import com.challenge.factorymethod.transaction.factory.FoodTransactionFactory
import com.challenge.factorymethod.transaction.factory.MealTransactionFactory
import com.challenge.factorymethod.transaction.factory.TransactionFactory

lateinit var app: TransactionFactory
lateinit var payloadTransaction: PayloadTransaction

fun main() {

    payloadTransaction = PayloadTransaction(
        "123",
        300.0,
        "5811",
        "PADARIA DO ZE",
        "2"
    )

    configureTransaction()
    runBusinessRules()
}

fun configureTransaction() {
    app = when(payloadTransaction.mcc) {
        in arrayOf("5411", "5412") -> FoodTransactionFactory()
        in arrayOf("5811", "5812") -> MealTransactionFactory()
        else -> CashTransactionFactory()
    }
}

fun runBusinessRules() {
    print(app.processTransaction(payloadTransaction))
}