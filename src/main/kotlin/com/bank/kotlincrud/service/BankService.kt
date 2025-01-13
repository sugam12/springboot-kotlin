package com.bank.kotlincrud.service

import com.bank.kotlincrud.dto.BankDto

interface BankService {
   fun createBank(bank: BankDto)
}