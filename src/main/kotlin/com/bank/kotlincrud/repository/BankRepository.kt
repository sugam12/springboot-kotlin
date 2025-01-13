package com.bank.kotlincrud.repository

import com.bank.kotlincrud.entity.BankEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface BankRepository : CrudRepository<BankEntity, Int> {
}