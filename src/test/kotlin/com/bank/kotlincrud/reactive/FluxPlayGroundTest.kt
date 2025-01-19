package com.bank.kotlincrud.reactive

import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import kotlin.RuntimeException


@SpringBootTest
class FluxPlayGroundTest {
    @Test
    fun fluxTest() {
        Flux.just("A", "B", "C")
            .log()
            .subscribe { data -> println(data) }
    }

    @Test
    fun fluxWithErrorTest() {
        Flux.just("A", "B", "C").concatWith(Flux.error(RuntimeException("Runtime exception occured")))
            .log()
            .subscribe({ data -> println(data) },
                { error -> println("error is $error") },
                { println("completed") })
    }

    @Test
    fun fluxWithIterableTest() {
        val listOf = listOf("A", "B", "C")
        Flux.fromIterable(listOf)
            .log()
            .subscribe { data -> println(data) }
    }

    @Test
    fun fluxWithRangeTest() {
        Flux.range(5, 4)
            .log()
            .subscribe { data -> println(data) }
    }

    @Test
    fun fluxWithIntervalTest() {
        Flux.interval(Duration.ofSeconds(1))
            .log()
            .subscribe { data -> println(data) }
        Thread.sleep(10000)
    }

    @Test
    fun fluxWithTakeTest() {
        Flux.interval(Duration.ofSeconds(1))
            .log()
            .take(2)
            .subscribe { data -> println(data) }
        Thread.sleep(10000)
    }

    @Test
    fun fluxWithRequestTest() {
        Flux.range(1, 9)
            .log()
            .subscribe({ data -> println(data) }, {}, {}, { sub -> sub.request(3) })
        Thread.sleep(10000)
    }

    // on hanlding the error or RuntimeException
    @Test
    fun fluxWithErrorHandleTest() {
        Flux.just("A", "B", "C")
            .concatWith(Flux.error(RuntimeException("Runtime exception")))
            .onErrorReturn("Error return")
            .log()
            .subscribe { data -> println(data) }
        Thread.sleep(5000)
    }

    @Test
    fun monoTest() {
        Mono.just("A")
            .log()
            .subscribe { data -> println("My data is $data") }
    }

    @Test
    fun monoErrorTest() {
        Mono.error<Exception>(Exception("Some exception occurred"))
            .log()
            .subscribe({}, { error ->
                println("Error occurred ${error.message}")
            })
    }

    @Test
    fun monoDoOnErrorTest() {
        Mono.error<Exception>(Exception("Some exception occurred"))
            .log()
            .doOnError { error ->
                println("Error occurred ${error.message}")
            }.subscribe()
    }

    /*@Test
    fun monoOnErrorResumeTest() {
        Mono.error<Exception>(Exception("Some exception occurred"))
            .log()
            .onErrorResume {
            }.subscribe()
    }*/


}