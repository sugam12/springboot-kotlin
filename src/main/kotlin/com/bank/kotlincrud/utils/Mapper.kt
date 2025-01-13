package com.bank.kotlincrud.utils

interface Mapper<D,E> {

    fun convertToEntity(domain: D):E
    fun convertToDomain(entity: E):D
}