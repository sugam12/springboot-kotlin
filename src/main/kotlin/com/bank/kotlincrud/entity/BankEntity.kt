package com.bank.kotlincrud.entity

import jakarta.persistence.*

@Entity
@Table(name = "TBL_BANK")
data class BankEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,
    val name: String,
    val email: String,
    val address: String
)
