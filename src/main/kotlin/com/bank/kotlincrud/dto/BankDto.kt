package com.bank.kotlincrud.dto

data class BankDto(
    val id:Int = -1,
    val name: String,
    val email: String,
    val address: String
)
