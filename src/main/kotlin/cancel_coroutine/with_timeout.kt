package cancel_coroutine

import kotlinx.coroutines.*

fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    withTimeout(1300) {
        try {
            for (i in 0..100) {
                print("$i.")
                delay(500)
            }
        } catch (ex: TimeoutCancellationException) {
            println("Oh no")
        } finally {
            // .. code..
        }
    }

    println("\nMain program ends: ${Thread.currentThread().name}")    // main thread
}