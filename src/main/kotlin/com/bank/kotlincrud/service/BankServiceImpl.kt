package com.bank.kotlincrud.service

import com.bank.kotlincrud.dto.BankDto
import com.bank.kotlincrud.exception.BankNotFoundException
import com.bank.kotlincrud.repository.BankRepository
import com.bank.kotlincrud.utils.BankMapper
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrElse
import kotlin.jvm.optionals.getOrNull

@Service
class BankServiceImpl(
    private val bankRepository: BankRepository,
    private val bankMapper: BankMapper
) : BankService {
    override fun createBank(bankDto: BankDto): BankDto {

        if (bankDto.id != -1) {
            throw IllegalArgumentException("id must be null or -1")
        }
        val bankEntity = bankMapper.convertToEntity(bankDto)
        bankRepository.save(bankEntity)

        return bankMapper.convertToDomain(bankEntity)
    }

    override fun findAllBank(): List<BankDto> {
        val bank = bankRepository.getAllBank()
        //var bankList = mutableListOf<BankDto>()
        return bank.map {
            bankMapper.convertToDomain(it)
        }
    }

    override fun findBankById(id: Int): BankDto {
        val bank = bankRepository.findById(id).getOrElse {
            throw BankNotFoundException("Bank not found")
        }
        return bankMapper.convertToDomain(bank)
    }

    override fun delete(id: Int) {
        val bank  = findBankById(id)
        bankRepository.deleteById(id)
    }
}