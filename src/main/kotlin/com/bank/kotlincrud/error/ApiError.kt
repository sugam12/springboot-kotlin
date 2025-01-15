package com.bank.kotlincrud.error

import org.springframework.http.HttpStatus

data class ApiError(
    val message: String?,
    val status: HttpStatus,
    val code : Int = status.value()
)
