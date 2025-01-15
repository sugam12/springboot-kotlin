package com.bank.kotlincrud.exception

import com.bank.kotlincrud.error.ApiError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(BankNotFoundException::class)
    fun handleBankNotFoundException(bankNotFoundException: BankNotFoundException): ResponseEntity<ApiError> {
        val badRequest = HttpStatus.BAD_REQUEST;
        val error = ApiError(bankNotFoundException.message, badRequest)
        return ResponseEntity(error, badRequest)
    }
}