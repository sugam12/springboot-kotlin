package com.bank.kotlincrud.repository

import com.bank.kotlincrud.entity.BankEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface BankRepository : CrudRepository<BankEntity, Int> {
    @Query("SELECT B FROM TBL_BANK as B")
    fun getAllBank(): List<BankEntity>
}