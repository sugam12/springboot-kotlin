package com.bank.kotlincrud.dto

import org.springframework.data.domain.AfterDomainEventPublication
import org.springframework.data.domain.DomainEvents
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

data class BankDto(
    val id: Int = -1,
    val name: String,
    val email: String,
    val address: String
)
//val domainEvents = mutableListOf<JvmType.Object>()
/*@DomainEvents
fun getDomainEvents(): MutableList<JvmType.Object> {
    return domainEvents
}
@AfterDomainEventPublication
fun clearDomainEvents() {
    domainEvents.clear()
}*/
