package composing_suspending

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

// Concurrent Execution - Achieve concurrent Execution
fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val time = measureTimeMillis {
        val msgOne:Deferred<String> = async {
            getMessageOne1()

        }
        val msgTwo: Deferred<String> = async {
            getMessageTwo1() }
        println("The entire message is: ${msgOne.await() + msgTwo.await()}")
    }

    println("Completed  in $time ms")
    println("Main program ends: ${Thread.currentThread().name}")    // main thread
}

suspend fun getMessageOne1(): String {
    delay(1000L)    // pretend to do some work
    return "Hello "
}

suspend fun getMessageTwo1(): String {
    delay(1000L)    // pretend to do some work
    return "World!"
}