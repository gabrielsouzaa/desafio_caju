package com.challenge.factorymethod.model

data class PayloadTransaction(
    val id: String,
    val amount: Double,
    val mcc: String,
    val merchant: String,
    val account: String
)