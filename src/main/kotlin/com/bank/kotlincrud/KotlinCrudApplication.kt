package com.bank.kotlincrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KotlinCrudApplication{
}

fun main(args: Array<String>) {
	runApplication<KotlinCrudApplication>(*args)
}
