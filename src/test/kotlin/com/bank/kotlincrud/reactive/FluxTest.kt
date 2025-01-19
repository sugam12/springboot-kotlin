package com.bank.kotlincrud.reactive

import org.junit.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier

class FluxTest {

    @Test
    fun fluxTest() {
        val flux = Flux.just("A", "B", "C")
            .log()
        StepVerifier.create(flux).expectNext("A", "B", "C").verifyComplete()
    }

    @Test
    fun fluxErrorTest() {
        val flux = Flux.just("A", "B", "C").concatWith(Flux.error(RuntimeException("Error Occurred")))
            .log()
        StepVerifier.create(flux).expectNext("A", "B", "C").expectError(RuntimeException::class.java).verify();
    }
}