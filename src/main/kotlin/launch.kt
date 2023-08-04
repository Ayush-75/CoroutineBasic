
import kotlinx.coroutines.*

fun main() =
    // Create a block coroutine that executes in current thread(main)
    runBlocking {

        println("Main Program start on : ${Thread.currentThread().name}") // main thread

        val job: Job = launch { // Thread : main

            println("Fake work Start : ${Thread.currentThread().name}") // Thread : main

            delay(1000) // Coroutine is suspended but Thread : main is free(not blocked)

            println("Fake work finished : ${Thread.currentThread().name}") //Either main thread or some other thread

        }

        // Cancel the coroutine
//        job.cancel()
        job.join() // wait for coroutine to finish the work

        println("Main Program Ends on : ${Thread.currentThread().name}") // main thread

    }
