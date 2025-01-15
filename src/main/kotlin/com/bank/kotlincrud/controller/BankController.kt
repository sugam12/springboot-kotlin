package com.bank.kotlincrud.controller

import com.bank.kotlincrud.dto.BankDto
import com.bank.kotlincrud.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/bank")
class BankController(
    private val bankService: BankService
) {
    @PostMapping()
    fun bank(@RequestBody bankDto: BankDto): ResponseEntity<BankDto> {
        return ResponseEntity(bankService.createBank(bankDto), HttpStatus.CREATED)
    }

    @GetMapping()
    fun bank(): ResponseEntity<List<BankDto>> {
        return ResponseEntity.ok(bankService.findAllBank())
    }

    @GetMapping("/{id}")
    fun bank(@PathVariable("id") id: Int): ResponseEntity<BankDto> {
        return ResponseEntity.ok(bankService.findBankById(id))
    }


    @DeleteMapping("/{id}")
    fun deleteBank(@PathVariable("id") id: Int): ResponseEntity<Unit> {
        return ResponseEntity(bankService.delete(id), HttpStatus.NO_CONTENT)
    }
}