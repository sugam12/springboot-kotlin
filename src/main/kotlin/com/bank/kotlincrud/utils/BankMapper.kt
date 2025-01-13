package com.bank.kotlincrud.utils

import com.bank.kotlincrud.dto.BankDto
import com.bank.kotlincrud.entity.BankEntity
import org.springframework.stereotype.Component

@Component
class BankMapper : Mapper<BankDto, BankEntity> {
    override fun convertToDomain(entity: BankEntity): BankDto {
        return BankDto(entity.id, entity.name, entity.email, entity.address)
    }

    override fun convertToEntity(domain: BankDto): BankEntity {
        return BankEntity(domain.id, domain.name, domain.email, domain.address)
    }
}