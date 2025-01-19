package com.bank.kotlincrud.reactive

import org.junit.Test
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import kotlin.Exception

class MonoTest {

    @Test
    internal fun monoTest() {
        val mono = Mono.just("A").log()
        mono.subscribe()

        StepVerifier.create(mono).expectNext("A").verifyComplete()
    }
}