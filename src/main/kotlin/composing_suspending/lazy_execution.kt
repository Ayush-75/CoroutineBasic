package composing_suspending

import kotlinx.coroutines.*

// Lazy Coroutine Execution - Lazily execute code

fun main() = runBlocking {    // Creates a blocking coroutine that executes in current thread (main)

    println("Main program starts: ${Thread.currentThread().name}")  // main thread

    val msgOne: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageOne2() }
    val msgTwo: Deferred<String> = async(start = CoroutineStart.LAZY) { getMessageTwo2() }
    println("The entire message is: ${msgOne.await() + msgTwo.await()}")

    println("Main program ends: ${Thread.currentThread().name}")    // main thread
}

suspend fun getMessageOne2(): String {
    delay(1000L)    // pretend to do some work
    println("After working in getMessageOne()")
    return "Hello "
}

suspend fun getMessageTwo2(): String {
    delay(1000L)    // pretend to do some work
    println("After working in getMessageTwo()")
    return "World!"
}
