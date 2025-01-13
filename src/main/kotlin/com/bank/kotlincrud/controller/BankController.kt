package com.bank.kotlincrud.controller

import com.bank.kotlincrud.dto.BankDto
import com.bank.kotlincrud.service.BankService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BankController(
    private val bankService: BankService
) {

   
    @PostMapping("/bank")
    fun bank(@RequestBody bankDto: BankDto) = bankService.createBank(bankDto)
}