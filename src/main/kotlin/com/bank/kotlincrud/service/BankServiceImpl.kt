package com.bank.kotlincrud.service

import com.bank.kotlincrud.dto.BankDto
import com.bank.kotlincrud.repository.BankRepository
import com.bank.kotlincrud.utils.BankMapper
import org.springframework.stereotype.Service

@Service
class BankServiceImpl(
    private val bankRepository: BankRepository,
    private val bankMapper: BankMapper
) : BankService{
    override fun createBank(bank: BankDto) {
        bankRepository.save(bankMapper.convertToEntity(bank))
    }
}