package com.bank.kotlincrud.service

import com.bank.kotlincrud.dto.BankDto

interface BankService {
   fun createBank(bankDto: BankDto) : BankDto
   fun findAllBank(): List<BankDto>

   fun findBankById(id: Int): BankDto

   fun delete(id: Int)
}