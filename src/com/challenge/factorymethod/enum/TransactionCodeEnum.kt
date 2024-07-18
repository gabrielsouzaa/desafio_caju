package com.challenge.factorymethod.enum

enum class TransactionCodeEnum(val code: String) {
    SUCCESS("00"),
    INSUFFICIENT_FUNDS("51"),
    INVALID_TRANSACTION("07")
}